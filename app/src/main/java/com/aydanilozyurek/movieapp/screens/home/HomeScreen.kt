package com.aydanilozyurek.movieapp.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aydanilozyurek.movieapp.model.Movie
import com.aydanilozyurek.movieapp.model.getMovies
import com.aydanilozyurek.movieapp.navigation.MovieScreens
import com.aydanilozyurek.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar ( colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
            title = {
                Text(text = "Movies")
            }
        )
    },) {
            innerPadding ->
        // Apply the padding globally to the whole BottomNavScreensController
        Box(modifier = Modifier.padding(innerPadding)) {
            MainContent(navController = navController)
        }

    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieLists : List<Movie> = getMovies()
){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieLists ){
                MovieRow(movie = it){
                        movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                }

            }
        }
    }
}