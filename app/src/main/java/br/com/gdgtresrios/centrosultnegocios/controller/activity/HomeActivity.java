package br.com.gdgtresrios.centrosultnegocios.controller.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosultnegocios.controller.fragment.CategoriaEventoFragment;
import br.com.gdgtresrios.centrosultnegocios.controller.fragment.ProximosEventosFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagerAdapter());
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter() {
            super(getSupportFragmentManager());
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                default:
                case 0:
                    return new ProximosEventosFragment();
                case 1:
                    return new CategoriaEventoFragment();
                case 2:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                default:
                case 0:
                    return getString(R.string.fragment_proximoseventos_title);
                case 1:
                    return getString(R.string.fragment_categoriaeventos_title);
                case 2:
                    return getString(R.string.fragment_categoriacolaboradores_title);
            }
        }
    }


}
