package br.com.gdgtresrios.centrosultnegocios.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.gdgtresrios.centrosulnegocios.R;
import br.com.gdgtresrios.centrosultnegocios.controller.fragment.CategoriaColaboradorFragment;
import br.com.gdgtresrios.centrosultnegocios.controller.fragment.CategoriaEventoFragment;
import br.com.gdgtresrios.centrosultnegocios.controller.fragment.ExpositoresFragment;
import br.com.gdgtresrios.centrosultnegocios.controller.fragment.PalestrantesFragment;
import br.com.gdgtresrios.centrosultnegocios.controller.fragment.PatrocinadoresFragment;
import br.com.gdgtresrios.centrosultnegocios.controller.fragment.ProximosEventosFragment;

public class ColaboradorActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colaborador);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagerAdapter());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.getMenu().getItem(1).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.drawer_evento) {
                    drawerLayout.closeDrawers();
                    startActivity(EventoActivity.newIntent(ColaboradorActivity.this));
                }
                return true;
            }
        });
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ColaboradorActivity.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
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
                    return new PatrocinadoresFragment();
                case 1:
                    return new ExpositoresFragment();
                case 2:
                    return new PalestrantesFragment();
                case 3:
                    return new CategoriaColaboradorFragment();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                default:
                case 0:
                    return getString(R.string.fragment_patrocinadores_title);
                case 1:
                    return getString(R.string.fragment_expositores_title);
                case 2:
                    return getString(R.string.fragment_palestrantes_title);
                case 3:
                    return getString(R.string.fragment_categoriacolaborador_title);
            }
        }
    }


}
