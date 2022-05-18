const service = {
  url: "/api"
}
export const environment = {
  production: true,
  pathRequest: {
    consultaLojas :  `${service.url}/api/consulta/lojas`,
    consultaTransacaoPorIdLoja : `${service.url}/api/consulta/transacao-por-loja`,
    parseFile : `${service.url}/api/parsefile/persist-file`
  }
};
