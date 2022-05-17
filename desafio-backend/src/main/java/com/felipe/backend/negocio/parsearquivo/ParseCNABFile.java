package com.felipe.backend.negocio.parsearquivo;

import com.felipe.backend.common.entity.Loja;
import com.felipe.backend.common.entity.Transacoes;
import com.felipe.backend.common.enums.ArquivoCNABConfig;
import com.felipe.backend.common.enums.TipoTransacaoConfig;
import com.felipe.backend.common.helper.NegocioGeral;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
@Component
public class ParseCNABFile extends NegocioGeral<MultipartFile, List<Transacoes>, List<Transacoes>> {
    final int maxlength = Arrays.stream(ArquivoCNABConfig.values())
            .max(Comparator.comparing(ArquivoCNABConfig::getValueFim))
            .get().getValueFim();

    @Override
    protected void checkInputConfig(MultipartFile input) throws Exception {
        String content = new String(input.getBytes(), StandardCharsets.UTF_8);
        Integer contentLength = content.replace("\n", "").length();
        Integer lineCount = content.split("\\r?\\n").length;
        log.info("" + (contentLength / lineCount));
        if( contentLength / lineCount != maxlength) throw new Exception("file out of linesize");
    }

    @Override
    protected List<Transacoes> execOperation(MultipartFile input) throws Exception {
        String content = new String(input.getBytes(), StandardCharsets.UTF_8);
        List<Loja> listaLoja = new ArrayList<>();
        List<Transacoes> negocio = new ArrayList<>();
        for(String line : content.split("\\n")){
            Transacoes transacaoAtual = new Transacoes();
            Loja lojaAtual = new Loja();
            for (ArquivoCNABConfig config : ArquivoCNABConfig.values()) {
                String currentElement = line.substring(config.getIndexInicio(), config.getValueFim());
                if(ArquivoCNABConfig.TIPO == config){
                    transacaoAtual.setTipoTransacao(getTipoTransacaoByTipo(Integer.valueOf(currentElement)));
                }
                if(ArquivoCNABConfig.DATA == config){
                    transacaoAtual.setDataOcorrencia(Long.valueOf(currentElement));
                }
                if(ArquivoCNABConfig.VALOR == config){
                    transacaoAtual.setValorMovimentacao(Double.valueOf(currentElement) / 100);
                }
                if(ArquivoCNABConfig.CPF == config){
                    transacaoAtual.setCpfBeneficiario(Long.valueOf(currentElement));
                }
                if(ArquivoCNABConfig.CARTAO == config){
                    transacaoAtual.setCartao(currentElement);
                }
                if(ArquivoCNABConfig.HORA == config){
                    transacaoAtual.setHoraOcorrencia(Long.valueOf(currentElement));
                }
                if(ArquivoCNABConfig.REPRESENTANTE == config){
                    lojaAtual.setRepresentante(currentElement.trim());
                }
                if(ArquivoCNABConfig.NOMELOJA == config){
                    lojaAtual.setNomeLoja(currentElement.trim());
                }
            }
            Loja finalLojaAtual = new Loja(lojaAtual.getNomeLoja(), lojaAtual.getRepresentante());
            if(listaLoja.stream().anyMatch(x -> x.getNomeLoja().equals(finalLojaAtual.getNomeLoja())
                    && x.getRepresentante().equals(finalLojaAtual.getRepresentante()))){
                lojaAtual = listaLoja.stream().filter(x -> x.getNomeLoja().equals(finalLojaAtual.getNomeLoja())
                        && x.getRepresentante().equals(finalLojaAtual.getRepresentante())).findFirst().get();
            } else {
                lojaAtual = finalLojaAtual;
                listaLoja.add(lojaAtual);
            }
            transacaoAtual.setLoja(lojaAtual);
            Double saldo = transacaoAtual.getTipoTransacao().getOperadorOperacao().applyAsDouble(lojaAtual.getSaldo(), transacaoAtual.getValorMovimentacao());
            lojaAtual.setSaldo(saldo);
            negocio.add(transacaoAtual);
        }
        return negocio;
    }

    @Override
    protected void checkBusiness(List<Transacoes> output) throws Exception {

    }

    @Override
    protected List<Transacoes> convertOutput(List<Transacoes> output) throws Exception {
        return output;
    }

    private TipoTransacaoConfig getTipoTransacaoByTipo(int tipo){
        return Arrays.stream(TipoTransacaoConfig.values()).filter(x -> x.getTipo() == tipo).findFirst().get();
    }
}
