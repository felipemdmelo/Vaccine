package com.felipemdmelo.vaccine.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.activities.base.BaseActivity;
import com.felipemdmelo.vaccine.models.PostoSaude;
import com.felipemdmelo.vaccine.models.PostoSaudeEstoque;
import com.felipemdmelo.vaccine.repositories.PostoSaudeRepository;
import com.felipemdmelo.vaccine.sharedprefs.UsuarioSharedPref;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private UsuarioSharedPref usuarioSharedPref;

    private PostoSaudeRepository postoSaudeRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        initAtributos();

        verificaUsuarioLogado();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.minha_carteira_menu:
                irPara(this, MinhaCarteiraActivity.class);
                return true;
            case R.id.logout_menu:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        carregaPostoSaude();
        
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                PostoSaude postoSaude = (PostoSaude) marker.getTag();

                LinearLayout ll = new LinearLayout(MapsActivity.this);
                ll.setPadding(20, 20, 20, 20);
                ll.setBackgroundColor(Color.WHITE);
                ll.setOrientation(LinearLayout.VERTICAL);

                TextView postoSaudeNomeTextView = new TextView(MapsActivity.this);
                SpannableString spanString = new SpannableString(postoSaude.getNome());
                spanString.setSpan(new StyleSpan(Typeface.BOLD), 0, spanString.length(), 0);
                postoSaudeNomeTextView.setText(spanString);
                ll.addView(postoSaudeNomeTextView);

                List<PostoSaudeEstoque> postoSaudeEstoqueList = postoSaude.getPostoSaudeEstoque();
                for (PostoSaudeEstoque postoSaudeEstoque :
                        postoSaudeEstoqueList) {

                    TextView tv = new TextView(MapsActivity.this);
                    tv.setText(postoSaudeEstoque.getVacina().getNome() + ": " + postoSaudeEstoque.getQtd());
                    ll.addView(tv);

                }

                return ll;
            }

            @Override
            public View getInfoContents(Marker marker) {
                return null;
            }
        });
    }

    private void initAtributos() {
        this.usuarioSharedPref = new UsuarioSharedPref(this);
        this.postoSaudeRepository = new PostoSaudeRepository();
    }

    private void verificaUsuarioLogado() {
        if(!this.usuarioSharedPref.isUsuarioLogado()) {
            irPara(this, LoginActivity.class);
        }
    }

    private void carregaPostoSaude() {
        List<PostoSaude> postoSaudeList = this.postoSaudeRepository.getAll();

        for (PostoSaude postoSaude :
             postoSaudeList) {
            addPostoSaudeMarker(postoSaude);
        }
    }

    private void addPostoSaudeMarker(PostoSaude postoSaude) {
        double latitude = trataLatitudeLongitude(postoSaude.getLatitude());
        double longitude = trataLatitudeLongitude(postoSaude.getLongitude());

        if(latitude != 0 && longitude != 0) {
            LatLng postoSaudeLatLng = new LatLng(latitude, longitude);
            Marker marker =  mMap.addMarker(
                    new MarkerOptions()
                            .position(postoSaudeLatLng)
                            .title(postoSaude.getNome()));

            marker.setTag(postoSaude);

            mMap.moveCamera(CameraUpdateFactory.newLatLng(postoSaudeLatLng));
        }
    }

    private double trataLatitudeLongitude(String latLng) {
        if(latLng != null && !latLng.isEmpty()) {
            try {
                return Double.parseDouble(latLng);
            } catch (Exception e) {
                return 0;
            }
        }

        return 0;
    }

    private void logout() {
        this.usuarioSharedPref.limpaUsuario();
        irPara(this, LoginActivity.class);
    }
}
