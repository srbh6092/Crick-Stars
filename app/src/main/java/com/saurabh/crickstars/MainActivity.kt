package com.saurabh.crickstars

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.saurabh.crickstars.databinding.ActivityMainBinding
import com.saurabh.crickstars.model.Player
import kotlinx.coroutines.InternalCoroutinesApi
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_country, R.id.navigation_name
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        var viewModel: PlayerViewModel = ViewModelProvider(
            this, ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(application)
        )
            .get(PlayerViewModel::class.java)

        //requesting for response
        val url="http://test.oye.direct/players.json"
        getResponse(viewModel,url)
    }

    //getting response
    @InternalCoroutinesApi
    private fun getResponse(viewModel: PlayerViewModel,url: String) {

        val countries =arrayOf<String>("Afghanistan","Australia","Bangladesh","England","India","New Zealand","Pakistan","South Africa","Sri Lanka","West Indies")

        //creating a GET request from the url
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            {

                //looping for every country
                for(country in countries){

                    //getting the object of the country
                    val afgJSONArray=it.getJSONArray(country)

                    for(i in 0 until afgJSONArray.length()){

                        //getting on player object
                        val playerJSONObject =afgJSONArray.getJSONObject(i)

                        //extracting details of the player from the object

                        var captain =false
                        if(playerJSONObject.has("captain"))
                            captain = playerJSONObject.getBoolean("captain")
                        val name = playerJSONObject.getString("name")

                        //splitting the name into first and last
                        var firstName = name
                        var lastName = ""
                        if(name.contains(" ")){
                            val arr: List<String> = name.split(" ")
                            firstName = arr[0]
                            lastName = arr[1]
                        }

                        //creating an object for players table
                        val player = Player(
                            captain,
                            firstName,
                            lastName,
                            country
                        )
                        //adding the player to the table
                        addRowInTable(viewModel,player)

                        Log.d(ContentValues.TAG, "getResponse : $name")
                    }
                }

            },
            {
                Log.d(ContentValues.TAG, "getResponse : $it")
            }
        )

        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)

    }

    @InternalCoroutinesApi
    private fun addRowInTable(viewModel: PlayerViewModel,player: Player) = viewModel.insertPlayer(player)
}