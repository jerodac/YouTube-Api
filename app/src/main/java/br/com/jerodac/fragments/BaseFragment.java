package br.com.jerodac.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.jerodac.MainActivity;
import br.com.jerodac.business.FlowManager;
import br.com.jerodac.controllers.MainController;
import br.com.jerodac.model.ModelPresenter;
import br.com.jerodac.utils.SnackBarUtil;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @author Jean Rodrigo Dalbon Cunha on 13/01/17.
 */
public abstract class BaseFragment extends Fragment {

    //Controller
    private MainController controller;

    //Butterknife binder
    private Unbinder unbinder;

    //Snackbar utilies
    protected SnackBarUtil snackBarUtil;

    /**
     * Deve retornar o resource referente ao layout do fragment
     *
     * @return|
     */
    protected int getLayoutResource() {
        return 0;
    }

    protected abstract void initComponents(View rootView);

    protected abstract void settings(View rootView);

    public String getTagName() {
        return "";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int resourceId = getLayoutResource();
        if (resourceId == 0) {
            return super.onCreateView(inflater, container, savedInstanceState);
        } else {
            return inflater.inflate(resourceId, container, false);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        controller = MainController.getInstance();
        settings(view);
        snackBarUtil = new SnackBarUtil(getView());
        initComponents(view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    public MainController getController() {
        return controller;
    }

    public ModelPresenter getModel() {
        return controller.getModel();
    }

    public MainActivity getBaseActivity() {
        return (MainActivity) getActivity();
    }

    public FlowManager getFlowManager() {
        return ((MainActivity) getActivity()).getFlowManager();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        snackBarUtil.onDestroy();
    }
}
