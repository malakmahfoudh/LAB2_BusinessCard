package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

// la couleur verte
val AndroidGreen = Color(0xFF3ddc84)

@Composable
fun ContactRow(
    icon: @Composable () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 70.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        // Icon
        icon()

        // Text
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}


@Composable
fun ContactInfoSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Téléphone
        ContactRow(
            icon = {
                Icon(
                    Icons.Default.Call,
                    contentDescription = "Numéro de téléphone",
                    tint = AndroidGreen,
                    modifier = Modifier.size(24.dp)
                )
            },
            text = "+216 99 802 100"
        )
        // Séparateur
        Spacer(modifier = Modifier.height(1.dp))

        // Réseau Social
        ContactRow(
            icon = {
                Icon(
                    Icons.Default.Share,
                    contentDescription = "Réseau social",
                    tint = AndroidGreen,
                    modifier = Modifier.size(24.dp)
                )
            },
            text = "@MalakMahfoudh"
        )
        // Séparateur
        Spacer(modifier = Modifier.height(1.dp))

        // E-mail
        ContactRow(
            icon = {
                Icon(
                    Icons.Default.Email,
                    contentDescription = "Adresse e-mail",
                    tint = AndroidGreen,
                    modifier = Modifier.size(24.dp)
                )
            },
            text = "malak.mahfoudh@android.com"
        )
    }
}


@Composable
fun NameAndTitleSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Le Logo
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "Logo Android",
            modifier = Modifier
                .size(120.dp)
                .background(Color.White)
                .padding(8.dp)
        )
        //  Le Nom
        Text(
            text = "Malak Mahfoudh",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp)
        )
        // Titre
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = AndroidGreen
        )
    }
}


@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier.weight(1f))


        NameAndTitleSection()

        // séparation
        Spacer(modifier = Modifier.weight(1f))


        ContactInfoSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        )
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}
