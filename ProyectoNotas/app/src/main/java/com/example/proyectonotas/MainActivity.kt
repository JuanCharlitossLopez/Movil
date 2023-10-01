package com.example.proyectonotas

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectonotas.ui.theme.ProyectoNotasTheme
import androidx.compose.ui.res.colorResource as colorResource1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer() //manda llamar nuestra aplicacion
        }
    }
}


@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewContainer() {
    Scaffold(
        //topBar = { Toolbar() },
        content = { Content() },
        floatingActionButton = { FAB() },
        floatingActionButtonPosition = FabPosition.End
    )
}

//ENCABEZADO DE LA APLICACION
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Toolbar() {
//    TopAppBar(
//        title = { Text(text = "ITSUR", color = colorResource1(id = R.color.black), textAlign = TextAlign.Center) },
//        Modifier.background(colorResource1(id = R.color.background))
//    )
//}

//BOTON FlONTANTE
@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = { Toast.makeText(context, "Hola", Toast.LENGTH_SHORT).show() })
    {
        Text(text = "+")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content() {
    // Poner un lazy colum para cuando ponemos en landScape
    // LazyColumn(content = )
    //COLUMNA
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
        ) {
            Text(
                text = "NOTAS",
                fontSize = 30.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f)//USO DE UN 50%
            )
            Text(
                text = "TAREAS",
                fontSize = 30.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(20.dp)
                    .background(Color.Gray)
                    .weight(1f)
            )
        }/* Image(
            painter = painterResource(id = R.drawable.agregar), contentDescription = null,
            Modifier
                .padding(1.dp, 1.dp)
                .height(50.dp)
                .width(50.dp)
        )*/
        //Text(text = "JUANCARLOS")
        // FILAS
        //Lazy Row para el scroll del la filas
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally)
            //.height(100.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.buscar),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                //.offset(30.dp, 0.dp)
            )
            var text by remember {
                mutableStateOf("Texto Inicial")
            }
            TextField(
                value = "Search",
                onValueChange = { text = it },
                singleLine = true,
                modifier = Modifier
                    //.padding(16.dp)
                    .width(250.dp)
                    .weight(1f)
                    .height(50.dp)
                //.offset(15.dp, -12.dp)
            )
            Image(
                painterResource(id = R.drawable.ajustes),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
        }
        //Notas
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(100.dp)
        ) {
            // variable para sacar el texto
            var text by remember {
                mutableStateOf("Texto Inicial")
            }
            TextField(
                value = "Text",
                onValueChange = { text = it },
                singleLine = true,
                modifier = Modifier
                    .padding(16.dp)
                    .width(100.dp)
                    .height(200.dp)

            )
            var text2 by remember {
                mutableStateOf("Texto Inicial")
            }
            TextField(
                value = "Text",
                onValueChange = { text2 = it },
                singleLine = true,
                modifier = Modifier
                    .padding(16.dp)
                    .width(100.dp)
                    .height(200.dp)
            )
        }
        //Slot 2
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(100.dp)
        ) {
            // variable para sacar el texto
            var text by remember {
                mutableStateOf("Texto Inicial")
            }
            TextField(
                value = "Text",
                onValueChange = { text = it },
                singleLine = true,
                modifier = Modifier
                    .padding(16.dp)
                    .width(100.dp)
                    .height(200.dp)
            )
            var text2 by remember {
                mutableStateOf("Texto Inicial")
            }
            TextField(
                value = "Text",
                onValueChange = { text2 = it },
                singleLine = true,
                modifier = Modifier
                    .padding(16.dp)
                    .width(100.dp)
                    .height(200.dp)
            )
        }
        // Crea el espacio para manda la fila hacia abajo
        Spacer(modifier = Modifier.weight(1f))
        //Menu
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.Gray)
                .padding(15.dp, 10.dp, 10.dp, 5.dp)
        ) {
            Text(
                text = "n. Notas",
                fontSize = 15.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .offset(150.dp)
                    .padding(5.dp)
            )
            //Image(
            //    painter = painterResource(id = R.drawable.agregar),
            //    contentDescription = null,
            //    modifier = Modifier
            //        .width(30.dp)
            //        .height(30.dp)
            //)
        }

    }
}