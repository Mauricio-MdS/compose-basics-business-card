package io.github.mauricio_mds.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.mauricio_mds.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardApp(
                        modifier = Modifier.padding(innerPadding).fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier.background(color = Color(0xFFD2E8D4)
        )) {
        MainInfo()
        ContactInfo()
    }
}

@Composable
fun MainInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .width(width = 100.dp)
                .background(color = Color(0xFF073042)),
        )
        Text(text = "Maurício da Silva", fontSize = 24.sp, modifier = Modifier.padding(top = 16.dp))
        Text(
            text = "Software Developer",
            fontSize = 16.sp,
            color = Color(0xFF006837),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_call_24),
                contentDescription = null,
                tint = Color(0xFF006837),
                modifier = Modifier.padding(end = 8.dp)

            )
                Text(text="(11) 234-5678")
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_alternate_email_24),
                contentDescription = null,
                tint = Color(0xFF006837),
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(text="@mauriciodev")
        }
        Row {
            Icon(
                painter = painterResource(id = R.drawable.baseline_email_24),
                contentDescription = null,
                tint = Color(0xFF006837),
                modifier = Modifier.padding(end = 8.dp))
            Text(text="mauricio@github.com")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp(modifier = Modifier.fillMaxSize())
    }
}