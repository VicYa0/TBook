package vic.tbook.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import vic.tbook.activity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment {


    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.ib_search)
    ImageButton mIbSearch;
    @BindView(R.id.gv_recog_content)
    GridView mGvRecogContent;
    @BindView(R.id.gv_hot_content)
    GridView mGvHotContent;
    @BindView(R.id.gv_latest_content)
    GridView mGvLatestContent;

    public StoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
