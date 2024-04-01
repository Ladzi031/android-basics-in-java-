/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.lunchtray

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.datasource.DataSource
import com.example.lunchtray.ui.AccompanimentMenuScreen
import com.example.lunchtray.ui.CheckoutScreen
import com.example.lunchtray.ui.EntreeMenuScreen
import com.example.lunchtray.ui.OrderViewModel
import com.example.lunchtray.ui.SideDishMenuScreen
import com.example.lunchtray.ui.StartOrderScreen

// TODO: Screen enum
enum class LunchTrayScreen(@StringRes val title: Int) {
    START(R.string.app_name),
    ENTREE_MENU(R.string.choose_entree),
    SIDE_DISH_MENU(R.string.choose_side_dish),
    ACCOMPANIMENT_MENU(R.string.choose_accompaniment),
    CHECKOUT(R.string.order_checkout)
}

// TODO: AppBar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LunchTrayAppBar(title: LunchTrayScreen, onBackButtonClicked: () -> Unit, enableBackButton: Boolean = false, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
        title = {
            Text(text = stringResource(id = title.title))
        },
        navigationIcon = {
            if(enableBackButton) {
                IconButton(onClick = onBackButtonClicked) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(id = R.string.back_button))
                }
            }
        }
    )
}

@Composable
fun LunchTrayApp(navController: NavHostController = rememberNavController()) {

    // TODO: Create Controller and initialization
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LunchTrayScreen.valueOf(backStackEntry?.destination?.route ?: LunchTrayScreen.START.name)

    // Create ViewModel
    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {

            // TODO: AppBar
            LunchTrayAppBar(
                title = currentScreen,
                onBackButtonClicked = { navController.navigateUp() },
                enableBackButton = navController.previousBackStackEntry != null
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        // TODO: Navigation host
        NavHost(navController = navController, startDestination = LunchTrayScreen.START.name, modifier = Modifier.padding(innerPadding)) {

            composable(LunchTrayScreen.START.name) {
                StartOrderScreen(
                    onStartOrderButtonClicked = { navController.navigate(LunchTrayScreen.ENTREE_MENU.name) },
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .fillMaxSize()
                )
            }
            composable(LunchTrayScreen.ENTREE_MENU.name) {
                EntreeMenuScreen(
                    options = DataSource.entreeMenuItems,
                    onCancelButtonClicked = { cancelOrderAndGoBack(viewModel, navController) },
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.SIDE_DISH_MENU.name) },
                    onSelectionChanged = { viewModel.updateEntree(it) },
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .verticalScroll(rememberScrollState())
                )
            }
            composable(LunchTrayScreen.SIDE_DISH_MENU.name) {
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = { cancelOrderAndGoBack(viewModel, navController) },
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.ACCOMPANIMENT_MENU.name) },
                    onSelectionChanged = { viewModel.updateSideDish(it) },
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .verticalScroll(rememberScrollState())
                )
            }
            composable(LunchTrayScreen.ACCOMPANIMENT_MENU.name) {
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = { cancelOrderAndGoBack(viewModel, navController) },
                    onNextButtonClicked = { navController.navigate(LunchTrayScreen.CHECKOUT.name) },
                    onSelectionChanged = { viewModel.updateAccompaniment(it)},
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .verticalScroll(rememberScrollState())
                )
            }
            composable(LunchTrayScreen.CHECKOUT.name) {
                CheckoutScreen(
                    orderUiState = uiState,
                    onNextButtonClicked = { navController.popBackStack(LunchTrayScreen.START.name, inclusive = false) },
                    onCancelButtonClicked = { cancelOrderAndGoBack(viewModel, navController) },
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .verticalScroll(rememberScrollState()))
            }
        }
    }
}

private fun cancelOrderAndGoBack( viewModel: OrderViewModel, navController: NavHostController) {
    viewModel.resetOrder()
    navController.popBackStack(LunchTrayScreen.START.name, inclusive = false)
}

