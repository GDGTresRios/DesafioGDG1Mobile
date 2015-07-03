package br.com.gdgtresrios.Utils;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by Wanderlei on 03/07/2015.
 */
public class TransacaoFragmentTask extends AsyncTask<Void, Void, Boolean> {

    private static final String TAG = "livroandroid";
    private final Context context;
    private final Fragment fragment;
    private final Transacao transacao;
    private Exception exceptionErro;
    private int progressID;

    public TransacaoFragmentTask(Fragment fragment, Transacao transacao, int progressID) {
        this.context = fragment.getActivity();
        this.fragment = fragment;
        this.transacao = transacao;
        this.progressID = progressID;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        try{
            showProgress();
        } catch (Exception e){
            Log.e(TAG, e.getMessage(), e);
        }
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try{
            transacao.executar();
        }catch (Exception e){
            Log.e(TAG, e.getMessage(), e);
            this.exceptionErro = e;
            return false;
        } finally {
            try{
                fragment.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        hideProgress();
                    }
                });
            } catch (Exception e){
                Log.e(TAG, e.getMessage(), e);
            }
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean b) {
        if (b){
            transacao.atualizarView();
        } else {
            Log.i(TAG, exceptionErro.getMessage());
        }
    }

    private void showProgress(){
        View view = fragment.getView();
        if (view != null) {
            ProgressBar progressBar = (ProgressBar) view.findViewById(progressID);
            if (progressBar != null){
                progressBar.setVisibility(View.VISIBLE);
            }
        }
    }

    private void hideProgress(){
        View view = fragment.getView();
        if (view != null){
            ProgressBar progressBar = (ProgressBar) view.findViewById(progressID);
            if (progressBar != null){
                progressBar.setVisibility(View.INVISIBLE);
            }
        }
    }
}
