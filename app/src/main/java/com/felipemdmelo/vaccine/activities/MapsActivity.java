package com.felipemdmelo.vaccine.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.felipemdmelo.vaccine.R;
import com.felipemdmelo.vaccine.activities.base.BaseActivity;
import com.felipemdmelo.vaccine.models.PostoSaude;
import com.felipemdmelo.vaccine.repositories.PostoSaudeRepository;
import com.felipemdmelo.vaccine.sharedprefs.UsuarioSharedPref;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
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
            mMap.addMarker(
                    new MarkerOptions()
                            .position(postoSaudeLatLng)
                            .title(postoSaude.getNome()));
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
