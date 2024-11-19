package com.combine.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.combine.login.presentation.LoginScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.combine.app.AppScreenModel.ContentState
import com.combine.app.tabs.FavoritesTab
import com.combine.app.tabs.HomeTab
import com.combine.app.tabs.ProfileTab
import com.combine.base.Colors
import com.combine.base.CombineTheme
import com.combine.base.ui.backgrounds.Background
import com.combine.base.ui.dialogs.LoadingDialog
import org.koin.compose.koinInject

internal interface AppContract {
    fun onContentStateChange(contentState: ContentState)
}

@Composable
@Preview
fun App() {
    val screenModel = koinInject<AppScreenModel>()
    val uiState by screenModel.uiState.collectAsStateWithLifecycle()

    CombineTheme {
        when (uiState.contentState) {
            ContentState.Loading -> LoadingDialog()
            ContentState.Login -> LoginContent(screenModel)
            ContentState.App -> AppContent()
        }
    }
}

@Composable
private fun LoginContent(contract: AppContract) {
    LoginScreen(
        onNavigateToApp = {
            contract.onContentStateChange(ContentState.App)
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun AppContent() {
    BottomSheetNavigator {
        TabNavigator(
            HomeTab,
            tabDisposable = {
                TabDisposable(
                    navigator = it,
                    tabs = listOf(HomeTab, FavoritesTab, ProfileTab)
                )
            }
        ) { _ ->
            Scaffold(
                content = { paddingValues ->
                    Box(modifier = Modifier.padding(paddingValues)) {
                        CurrentTab()
                    }
                },
                bottomBar = {
                    BottomAppBar(
                        windowInsets = AppBarDefaults.bottomAppBarWindowInsets,
                        backgroundColor = Colors.pastelBlue,
                        contentColor = Color.Black,
                        cutoutShape = CircleShape,
                        elevation = 0.dp
                    ) {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(FavoritesTab)
                        TabNavigationItem(ProfileTab)
                    }

                },
            )
        }
    }
}

@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) },
        label = { Text(text = tab.options.title) },
        alwaysShowLabel = true,
        selectedContentColor = Color.Black,
        unselectedContentColor = Colors.background
    )
}