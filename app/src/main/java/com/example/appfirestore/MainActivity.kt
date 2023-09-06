@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.appfirestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfirestore.ui.theme.AppFirestoreTheme
import android.icu.text.DateFormat
import android.icu.util.TimeZone
import android.os.Build
import android.widget.DatePicker
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clipScrollableContainer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfirestore.ui.theme.AppFirestoreTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.window.Popup
import androidx.compose.ui.zIndex
import com.example.appfirestore.ui.theme.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.Instant
import java.time.ZoneId
import java.util.Calendar
import androidx.compose.material.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import java.util.Date
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import android.os.LocaleList
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.platform.LocalDensity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFirestoreTheme {
                CadastroScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen() {
    // Simulação de uma lista de itens no Column
    val items = List(50) { "Item $it" }

    // Defina a altura do espaço de exibição visível
    val visibleContentHeight = 400.dp

    // Use o estado para controlar a posição da barra de rolagem
    var scrollState by remember { mutableStateOf(0f) }

    // Use o DensityOwner para obter a densidade do dispositivo
    val density = LocalDensity.current.density

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .padding(16.dp)
        ) {
            CadastroTopBar()
            Spacer(modifier = Modifier.height(100.dp))
            TextInicial()
            Spacer(modifier = Modifier.height(16.dp))
            SimpleNameOutlinedTextFieldSample()
            Spacer(modifier = Modifier.height(16.dp))
            SimpleTelefoneOutlinedTextFieldSample()
            Spacer(modifier = Modifier.height(16.dp))
            ExposedDropdownMenuSample()
            Spacer(modifier = Modifier.height(16.dp))
            DatePickerSample()
            Spacer(modifier = Modifier.height(50.dp))
            TextAreaSample()
            Spacer(modifier = Modifier.height(16.dp))
            ButtonCadastrar()
            Spacer(modifier = Modifier.height(16.dp))
            ButtonCancelar()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroTopBar() {
        TopAppBar(
            title = { Text("AppFirestore - Cadastro") },
            // Outros itens do menu aqui, se necessário
        )
}

@Composable
fun TextInicial() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crie sua Conta:",
            fontSize = 35.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Nome") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SimpleNameOutlinedTextFieldSample() {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        NameOutlinedTextField(
            value = name,
            onValueChange = { name = it }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelefoneOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Telefone") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun SimpleTelefoneOutlinedTextFieldSample() {
    var telefone by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        TelefoneOutlinedTextField(
            value = telefone,
            onValueChange = { telefone = it }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropdownMenuSample() {
    val options = listOf("Brasileira", "Indígena", "Asiática", "Americana", "Européia")
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                // The `menuAnchor` modifier must be passed to the text field for correctness.
                modifier = Modifier.menuAnchor(),
                readOnly = true,
                value = selectedOptionText,
                onValueChange = {},
                label = { Text("Origem") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
    }
}

@Composable
fun DatePickerSample() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        // Pre-select a date for January 4, 2020
        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)
        DatePicker(state = datePickerState, modifier = Modifier.padding(16.dp))
    }
}
@Composable
fun DateInputSample() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        val state = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
        DatePicker(state = state, modifier = Modifier.padding(16.dp))

        Text("Entered date timestamp: ${state.selectedDateMillis ?: "no input"}")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextAreaSample() {
    var observacao by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        horizontalAlignment = Alignment.Start
    ) {
        TextField(
            value = observacao,
            onValueChange = { newValue ->
                observacao = newValue
            },
            label = { Text("Observação") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(100.dp) // Definindo uma altura mínima para a TextArea
        )
    }
}

@Composable
fun ButtonCadastrar() {
    ExtendedFloatingActionButton(
        onClick = { /* do something */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp) // Reduzir o espaço superior
            .height(48.dp) // Altura reduzida
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        containerColor = Color.Blue, // Usando a cor laranja personalizada
        contentColor = Color.Black,
        shape = MaterialTheme.shapes.small.copy(CornerSize(4.dp)) // Bordas menos arredondadas
    ) {
        Text(text = "CADASTRAR", color = Color.White)
    }
}

@Composable
fun ButtonCancelar() {
    ExtendedFloatingActionButton(
        onClick = { /* do something */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp) // Reduzir o espaço superior
            .height(48.dp) // Altura reduzida
            .padding(horizontal = 16.dp), // Espaçamento horizontal reduzido
        containerColor = Color.Blue, // Usando a cor laranja personalizada
        contentColor = Color.Black,
        shape = MaterialTheme.shapes.small.copy(CornerSize(4.dp)) // Bordas menos arredondadas
    ) {
        Text(text = "CANCELAR", color = Color.White)
    }
}

@Preview
@Composable
fun CadastroScreenPreview() {
    CadastroScreen()
}

@Preview
@Composable
fun BarraSuperiorPreview() {
    CadastroTopBar()
}

@Preview
@Composable
fun TextInicialPreview() {
    TextInicial()
}

@Preview
@Composable
fun TextFieldNomePreview() {
    SimpleNameOutlinedTextFieldSample()
}

@Preview
@Composable
fun TextFieldTelefonePreview() {
    SimpleTelefoneOutlinedTextFieldSample()
}

@Preview
@Composable
fun OrigemPreview() {
    ExposedDropdownMenuSample()
}

@Preview
@Composable
fun DatePreview() {
    DatePickerSample()
}

@Preview
@Composable
fun TextAreaObservacaoPreview() {
    TextAreaSample()
}

@Preview
@Composable
fun ButtonCadastrarPreview() {
    ButtonCadastrar()
}

@Preview
@Composable
fun ButtonCancelarPreview() {
    ButtonCancelar()
}