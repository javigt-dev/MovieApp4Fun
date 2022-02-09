package com.javier.movieapp4fun.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.javier.movieapp4fun.model.getMovies

@Composable
fun DetailScreen(
    navController: NavController,
    movieId: String?
) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.LightGray,
            elevation = 5.dp
        ) {
            Row(
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    },
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "ArrowBack")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Go Back")
            }
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = newMovieList[0].title,
                    style = MaterialTheme.typography.body2)
            }
        }
    }
}
    

