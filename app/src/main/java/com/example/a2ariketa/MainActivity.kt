package com.example.a2ariketa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a2ariketa.ui.theme._2AriketaTheme
import android.view.Gravity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ariketa2()
        }
    }
}

@Composable
fun Ariketa2() {
    val context = LocalContext.current
    var izena by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Hau nahi nuen izenbura bezala, baina...
        Text(
            text = "2. Ariketa - Toast",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(256.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Bete ezazu",
                fontSize = 20.sp,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
               // modifier = Modifier.weight(1f)
            )
            TextField(
                value = izena,
                onValueChange = { izena = it },
                label = { Text("NAME") },
                modifier = Modifier.weight(2f)
            )
//            OutlinedTextField(
//                value = izena,
//                onValueChange = {izena = it},
//                label = {Text("NAME")},
//                modifier = Modifier.weight(2f)
//            )
        }

        Spacer(modifier = Modifier.height(256.dp))

        Button(onClick = {
            //Log
            Log.d("MainActivity", "Button clicked")

            if (izena.isBlank()) {
                Toast.makeText(context, "Izena ezin da hutsik egon", Toast.LENGTH_SHORT).show()
            } else {
                if (izena == "Kaixo Mundua") {
                    val toast = Toast.makeText(context, "Kaixo Mundua", Toast.LENGTH_LONG)
                    toast.show()
                    val intent = Intent(context, BigarrenActivity::class.java)
                    context.startActivity(intent)
                } else{
                    Toast.makeText(context, "Kaixo ${izena}", Toast.LENGTH_LONG).show()
                }
            }
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        ){
            Text("Sakatu")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _2AriketaTheme {
        Ariketa2()
    }
}