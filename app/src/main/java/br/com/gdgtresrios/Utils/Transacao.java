package br.com.gdgtresrios.Utils;

/**
 * Created by Wanderlei on 03/07/2015.
 */
public interface Transacao {
    void executar() throws Exception;

    void atualizarView();
}
