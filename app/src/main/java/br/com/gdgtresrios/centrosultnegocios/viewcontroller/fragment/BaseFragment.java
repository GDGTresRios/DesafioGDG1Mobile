package br.com.gdgtresrios.centrosultnegocios.viewcontroller.fragment;

import android.support.v4.app.Fragment;

import br.com.gdgtresrios.Utils.Transacao;
import br.com.gdgtresrios.Utils.TransacaoFragmentTask;
import br.com.gdgtresrios.centrosulnegocios.R;

/**
 * Created by Wanderlei on 03/07/2015.
 */
public class BaseFragment extends Fragment {

    private int progressId = R.id.progress;

    public void startTransacao(Transacao transacao){

        TransacaoFragmentTask task = new TransacaoFragmentTask(this, transacao, progressId);
        task.execute();

    }

    public void setProgressId(int progressId){
        this.progressId = progressId;
    }
}
