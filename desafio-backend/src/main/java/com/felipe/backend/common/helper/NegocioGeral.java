package com.felipe.backend.common.helper;

/*
* E -> Input Class
* N -> Business Class (Entity or DTO)
* S -> Output Class
 */
public abstract class NegocioGeral <E, N, S>{

    public S exec(final E input) throws Exception{
        checkInputConfig(input);

        N output = execOperation(input);

        checkBusiness(output);

        return convertOutput(output);
    }

    protected abstract void checkInputConfig( final E input ) throws Exception;

    protected abstract N execOperation( final E input ) throws Exception;

    protected abstract void checkBusiness( final N output) throws Exception;

    protected  abstract S convertOutput(final N output) throws Exception;
}
