package com.example.appfinanzas




import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appfinanzas.ui.theme.AppFinanzasTheme
import com.example.appfinanzas.ui.theme.*



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFinanzasTheme {
                AppNavegacion()
            }

        }
    }
}

@Composable
fun AppNavegacion(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicioView"){

        composable("InicioView") {
            InicioView(modifier = Modifier.fillMaxSize()
                    .background(casi_blanco),
                navController = navController)
        }

        composable ("SignUpView"){
            SignUpView(modifier = Modifier.fillMaxSize()
                .background(casi_blanco),
                navController = navController)
        }
    }

}

@Composable
fun InicioView( modifier: Modifier, navController: NavHostController) {

    Column(
        modifier.padding(vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row {
            Logo(
                modifier = Modifier
                    .width(200.dp)
                    .height(100.dp)
                    .background(casi_blanco)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Inicia tu sesión")

        Spacer(modifier = Modifier.height(40.dp))


        CustomTextField(
            value = "",
            onValueChange = {},
            label = "Correo electrónico",
            placeholder = "ejemplo@ejemplo.com",
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(
            value = "",
            onValueChange = {},
            label = "Contraseña",
            placeholder = "***********",
            isPassword = true,
            trailingIcon = {
                IconButton(onClick = {} ) {
                    Icon(painter = painterResource(R.drawable.ojo),
                        contentDescription = "Ver contraseña"
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(61.dp))

        BotonGenerico("Iniciar Sesión")

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedButton("Olvidó su contraseña", 0xFF01A593)

        Spacer(modifier = Modifier.height(20.dp))

        DivisiveLine()


        OutlinedButton(texto= "Iniciar con Google",
            colorBorde = 0xFF737D8C,
            icon = painterResource(R.drawable.google))

        Spacer(modifier = Modifier.height(40.dp))

        Text ("Si no posees tu cuenta")
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Créala ")
            Text(text = "AQUÍ",
                style = TextStyle(
                    color = Color(0xFF42ECB9)),
                modifier = Modifier
                    .clickable{
                       navController.navigate("SignUpView")

                    }


            )
        }



    }
}

@Composable
fun Logo(modifier: Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center) {
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "logo empresa",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize())
    }

}



    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        AppFinanzasTheme {
            InicioView(modifier = Modifier.fillMaxSize()
                .background(casi_blanco), navController = rememberNavController())
        }
    }

@Composable
fun BotonGenerico(texto: String){
    Button(onClick = {},
        modifier = Modifier
            .width(359.dp)
            .height(52.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF01A593)
        )
    )
    {
        (Text (text = texto,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF)
            ))
                )
    }

}

@Composable
fun OutlinedButton (texto: String, colorBorde:Long, icon: Painter?){
    Button(onClick = {},
        modifier = Modifier
            .width(359.dp)
            .height(52.dp)
            .border(1.dp,
                color = Color(colorBorde),
                shape = RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White),

    )
    {
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            if (icon != null){
                Image (
                    painter = icon,
                    contentDescription = "null",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
            (Text (text = texto,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                color = Color(colorBorde)
            ))
                )
        }
    }
}

@Composable
fun OutlinedButton (texto: String, colorBorde:Long){
    OutlinedButton(
        texto = texto,
        colorBorde = colorBorde,
        icon  = null)
}

@Composable
fun DivisiveLine() {
    Row(
        modifier = Modifier
            .width(359.dp)
            .padding(vertical = 16.dp)
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color(0xFF737D8C)
        )

        Text(
            text = " O ",
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .offset(y = (-11).dp),
            color = Color(0xFF737D8C)
        )

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color(0xFF737D8C)
        )
    }
}
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    isPassword: Boolean = false,
    trailingIcon: @Composable (() -> Unit)?=null
) {
        Box(
            modifier = Modifier
                .width(359.dp)
                .height(52.dp)

        ) {

            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        text = placeholder,
                        color = Color.Gray,
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(6.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFF737D8C),
                    focusedBorderColor = Color(0xFF737D8C),
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                ),
                singleLine = true,
                visualTransformation =
                    if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = trailingIcon
            )

            Text(
                text = label,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color(0xFF737D8C),
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .offset(x= 16.dp, y = (-7).dp)
                    .background(casi_blanco)
                    .padding(horizontal = 4.dp)
            )

        }

}





