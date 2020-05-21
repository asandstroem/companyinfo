package com.example.companyinfoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_map, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map_view)
        as? SupportMapFragment
        mapFragment?.getMapAsync(this)

        return v
    }

    override fun onMapReady(p0: GoogleMap?) {
        mMap = p0!!
        val ericssonQuarters = LatLng(59.4049047, 17.9530257)
        var zoomLevel = 16.0f
        mMap.addMarker(MarkerOptions().position(ericssonQuarters))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ericssonQuarters, zoomLevel))
    }
}