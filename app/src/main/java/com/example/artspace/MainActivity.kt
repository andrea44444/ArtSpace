package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Elementos()
                }
            }
        }
    }
}

@Composable
fun Elementos(modifier: Modifier = Modifier) {
    var obraActual by remember { mutableStateOf(1) }
    var titulo: String= stringResource(id = R.string.tituloObra1)
    var artista: String = stringResource(id = R.string.artista1)
    var anio: String = stringResource(id = R.string.año1)
    var img= R.drawable.obra1

    when (obraActual) {
        1 -> {
            titulo = stringResource(id = R.string.tituloObra1)
            img = R.drawable.obra1
            artista = stringResource(id = R.string.artista1)
            anio = stringResource(id = R.string.año1)
        }
        2 -> {
            titulo = stringResource(id = R.string.tituloObra2)
            img = R.drawable.obra2
            artista = stringResource(id = R.string.artista2)
            anio = stringResource(id = R.string.año2)
        }
        3 -> {
            titulo = stringResource(id = R.string.tituloObra3)
            img = R.drawable.obra3
            artista = stringResource(id = R.string.artista3)
            anio = stringResource(id = R.string.año3)
        }
        0 ->{
            obraActual= 3
        }
        else -> {
            obraActual= 1
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier
                .size(width = 300.dp, height = 500.dp)
        )
        Column(
            horizontalAlignment= Alignment.CenterHorizontally,
            modifier= Modifier
                .width(300.dp)
                .background(Color.LightGray),
            ){
            Text(
                text = titulo,
                fontSize = 30.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                lineHeight = 30.sp,
                modifier =Modifier.padding(10.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text(
                    text = artista,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    modifier =Modifier.padding(5.dp),
                )
                Text(
                    text = anio,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Light,
                    modifier =Modifier.padding(5.dp),
                )
            }
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth()

        ){
            Button(onClick = {
                obraActual--
            },
                modifier.size(width = 150.dp, height = 40.dp)
            ){
                Text(
                    text = "Previous",
                    fontSize = 17.sp,
                )
            }

            Button(onClick = {
                obraActual++
            },
                modifier.size(width = 150.dp, height = 40.dp)
            ){
                Text(
                    text = "Next" ,
                    fontSize = 17.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Elementos()
    }
}