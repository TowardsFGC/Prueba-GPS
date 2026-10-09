package com.example.evaluaciongps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MainActivity : AppCompatActivity() {

    private var map: MapView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Configuration.getInstance().setUserAgentValue("Mapa/ juan@gmail.com")

        setContentView(R.layout.activity_main)

        map = findViewById(R.id.map)

        map?.setTileSource(TileSourceFactory.MAPNIK)

        map?.setMultiTouchControls(true)

        val puntoInicial = GeoPoint(
            -33.498895,
            -70.616617
        )

        val punto2 = GeoPoint(
            -33.498720,
            -70.616130
        )

        val punto3 = GeoPoint(
            -33.498561,
            -70.615666
        )

        map?.controller?.setZoom(15.0)
        map?.controller?.setCenter(puntoInicial)

        val markerPolicia = Marker(map)
        markerPolicia.position = puntoInicial
        markerPolicia.title = "Gato Policía"
        markerPolicia.snippet = "Este gato es policía"
        markerPolicia.icon = ContextCompat.getDrawable(
            this,
            R.drawable.gato_polica
        )

        val markerLadron = Marker(map)
        markerLadron.position = punto2
        markerLadron.title = "Gato Ladrón"
        markerLadron.snippet = "Este gato es ladrón"
        markerLadron.icon = ContextCompat.getDrawable(
            this,
            R.drawable.gato_ladron
        )

        val markerVendedor = Marker(map)
        markerVendedor.position = punto3
        markerVendedor.title = "Gato Vendedor"
        markerVendedor.snippet = "Este gato es vendedor"
        markerVendedor.icon = ContextCompat.getDrawable(
            this,
            R.drawable.gato_polica
        )

        map?.overlays?.add(markerPolicia)
        map?.overlays?.add(markerLadron)
        map?.overlays?.add(markerVendedor)

        map?.invalidate()
    }

    override fun onResume() {
        super.onResume()

        map?.onResume()
    }

    override fun onPause() {
        super.onPause()

        map?.onPause()
    }
}