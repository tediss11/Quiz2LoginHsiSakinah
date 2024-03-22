package com.example.quiz2loginhsisakinah

import androidx.compose.material3.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz2loginhsisakinah.ui.theme.Quiz2LoginHsiSakinahTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Quiz2LoginHsiSakinahTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormSakinah()
                }
            }
        }
    }
}

@Composable
fun FormSakinah(
    modifier: Modifier = Modifier
) {
    var nipInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(id = R.drawable.quiz2_hsi_sakinah),
            contentDescription = null,
            modifier = modifier

        )

        Spacer(modifier = Modifier.height(72.dp))

        Text(
            textAlign = TextAlign.Left,
            text = stringResource(R.string.nip),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle(R.font.be_vietnam),
            fontSize = 20.sp
        )

        EditNipPassword(
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = nipInput,
            onValueChanged = { nipInput = it },
            modifier = modifier
                .fillMaxWidth()
        )

        Spacer(modifier = modifier.height(18.dp))

        Text(
            textAlign = TextAlign.Left,
            text = stringResource(R.string.password),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle(R.font.be_vietnam),
            fontSize = 20.sp
        )
        EditNipPassword(
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            value = passwordInput,
            onValueChanged = { passwordInput = it },
            modifier = modifier
                .padding(bottom = 18.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = modifier.height(18.dp))

        Button(
            shape = RoundedCornerShape(30),
            onClick = {if(nipInput==null) {
                Toast.makeText(context, "NIP kosong", Toast.LENGTH_SHORT).show()
            }else {Toast.makeText(context, "NIP isi", Toast.LENGTH_SHORT).show()
            }},
            colors = ButtonDefaults.buttonColors(Color(0xff2596be)),
            modifier = modifier

        ) {
            Text(
                stringResource(R.string.login),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth(),
                fontSize = 20.sp,
                fontStyle = FontStyle(R.font.be_vietnam),
            )
        }

        Spacer(modifier = modifier.height(48.dp))
        Text(
            textAlign = TextAlign.Center,
            text = stringResource(R.string.belum_bisa_akses),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle(R.font.be_vietnam),
            fontSize = 20.sp
        )

        Spacer(modifier = modifier.height(18.dp))
        Text(
            fontStyle = FontStyle(R.font.be_vietnam),
            textAlign = TextAlign.Center,
            color = Color(0xff2596be),
            text = stringResource(R.string.hubungi_cs_ikhwan),
            modifier = modifier
                .clickable {
                    Toast
                        .makeText(context, R.string.menghubungi_cs_ikhwan, Toast.LENGTH_SHORT)
                        .show()
                }
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = modifier.height(18.dp))
        Text(
            textAlign = TextAlign.Center,
            color = Color(0xff2596be),
            text = stringResource(R.string.hubungi_cs_akhwat),
            modifier = modifier
                .clickable {
                    Toast
                        .makeText(context, R.string.menghubungi_cs_akhwat, Toast.LENGTH_SHORT)
                        .show()
                }
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle(R.font.be_vietnam),
            fontSize = 20.sp
        )

        Spacer(modifier = modifier.height(72.dp))

        OutlinedButton(
            border = BorderStroke(1.dp, Color(0xff2596be)),
            shape = RoundedCornerShape(30),
            modifier = modifier.fillMaxWidth(),
            onClick = {
                Toast.makeText(context, R.string.menuju_halaman_faq, Toast.LENGTH_SHORT).show()
            },
        ) {
            Row {

                Text(
                    stringResource(R.string.lihat_faq),
                    textAlign = TextAlign.Center,
                    color = Color(0xff2596be),
                    modifier = modifier,
                    fontSize = 20.sp,
                    fontStyle = FontStyle(R.font.be_vietnam),
                )

                Icon(
                    modifier = modifier
                        .padding(3.dp),
                    imageVector = Icons.Default.ExitToApp, contentDescription = "",
                    tint = Color(0xff2596be)
                )
            }
        }
    }
}

@Composable
fun EditNipPassword(
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {

    TextField(
        shape = RoundedCornerShape(25),
        value = value,
        onValueChange = onValueChanged,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Quiz2LoginHsiSakinahTheme {
        FormSakinah()
    }
}