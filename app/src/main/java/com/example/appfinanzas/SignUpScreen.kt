package com.example.appfinanzas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appfinanzas.ui.theme.AppFinanzasTheme
import com.example.appfinanzas.ui.theme.casi_blanco

class SignUpScreen: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFinanzasTheme {
                SignUpView(modifier = Modifier.fillMaxSize()
                    .background(casi_blanco), navController = rememberNavController()
                )
            }

        }
    }



}

    @Composable
    fun SignUpView(modifier: Modifier, navController: NavController) {

        Column(
            modifier.padding(vertical = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row {
                Logo(
                    modifier = Modifier
                        .width(200.dp)
                        .height(100.dp)
                        .background(casi_blanco)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Completa los campos para registrarte")

            Spacer(modifier = Modifier.height(10.dp))


            CustomTextField(
                value = "",
                onValueChange = {},
                label = "Nombre y Apellidos",
                placeholder = "Tu nombre",
            )

            CustomTextField(
                value = "",
                onValueChange = {},
                label = "Correo electrónico",
                placeholder = "ejemplo@ejemplo.com"
            )
            CustomTextField(
                value = "",
                onValueChange = {},
                label = "Contraseña",
                placeholder = "*********",
                isPassword = true,
                trailingIcon = {
                    IconButton(onClick = {} ) {
                        Icon(painter = painterResource(R.drawable.ojo),
                            contentDescription = "Ver contraseña"
                        )
                    }
                }
            )

            CustomTextField(
                value = "",
                onValueChange = {},
                label = "Repetir Contraseña",
                placeholder = "*********",
                isPassword = true,
                trailingIcon = {
                    IconButton(onClick = {} ) {
                        Icon(painter = painterResource(R.drawable.ojo),
                            contentDescription = "Ver contraseña"
                        )
                    }
                }
            )

            CustomTextField(
                value = "",
                onValueChange = {},
                label = "Páis",
                placeholder = "España",
                trailingIcon = {
                    IconButton(onClick = {} ) {
                        Icon(painter = painterResource(R.drawable.chevron),
                            contentDescription = "Desplegar países"
                        )
                    }
                }
            )

            BotonGenerico("Iniciar Sesión")

            Column() {
                Text("Si ya tienes cuenta")
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Inicia sesión ")


                    Text(
                        text = "AQUÍ",
                        style = TextStyle(
                            color = Color(0xFF42ECB9)
                        ),
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                            }

                    )
                }
            }




        }
    }


    @Preview(showBackground = true)
    @Composable
    fun RegistroPreview() {
        AppFinanzasTheme {
            SignUpView(modifier = Modifier.fillMaxSize()
                .background(casi_blanco), navController = rememberNavController())
        }
    }
