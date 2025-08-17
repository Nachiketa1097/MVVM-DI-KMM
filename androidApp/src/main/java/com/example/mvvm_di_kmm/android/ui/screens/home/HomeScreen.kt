package com.example.mvvm_di_kmm.android.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mvvm_di_kmm.SharedRes
import com.example.mvvm_di_kmm.android.ui.component.AppColor
import com.example.mvvm_di_kmm.android.ui.component.TextComp
import com.example.mvvm_di_kmm.android.util.getStrings
import com.example.mvvm_di_kmm.util.BottomNavScreen
import com.example.mvvm_di_kmm.util.Screen
import dev.icerock.moko.resources.compose.fontFamilyResource
import dev.icerock.moko.resources.compose.painterResource
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.7f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(top = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(SharedRes.images.app_logo_60),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.size(60.dp)
                        )
                        TextComp(
                            text = getStrings(SharedRes.strings.hi),
                        )
                    }

                    TextComp(
                        text = getStrings(SharedRes.strings.profile),
                        textModifier = Modifier.padding(top = 16.dp)
                            .clickable {
                                navController.navigate(Screen.Login.route)
                            }
                    )
                    TextComp(
                        text = getStrings(SharedRes.strings.home),
                        textModifier = Modifier.padding(top = 16.dp)
                            .clickable {
                                navController.navigate(Screen.SignUp.route)
                            }
                    )
                    TextComp(
                        text = getStrings(SharedRes.strings.wallet),
                        textModifier = Modifier.padding(top = 16.dp)
                            .clickable {
                                navController.navigate(Screen.Profile.route)
                            }
                    )

                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        TextComp(
                            text = getStrings(SharedRes.strings.hi),
                            style = TextStyle(
                                color = AppColor.text,
                                fontSize = 16.sp,
                                lineHeight = 16.sp,
                                fontFamily = fontFamilyResource(SharedRes.fonts.poppins_semibold)
                            )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            },
            bottomBar = {
                val screens = listOf(
                    BottomNavScreen.Home,
                    BottomNavScreen.Product,
                    BottomNavScreen.Notes
                )
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                NavigationBar {
                    screens.forEach { screen ->
                        val selected = currentDestination?.route == screen.route

                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {
                                Image(
                                    painter = painterResource(screen.icon),
                                    contentDescription = screen.title,
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier.size(36.dp)
                                )
                            },
                            label = {
                                TextComp(text = screen.title)
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.White,
                                selectedTextColor = Color.White,
                                indicatorColor = Color(0xFF2196F3),
                                unselectedIconColor = Color.Gray,
                                unselectedTextColor = Color.Gray
                            )
                        )
                    }
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                TextComp(
                    text = getStrings(SharedRes.strings.welcome_message),
                    style = TextStyle(
                        color = AppColor.text,
                        fontSize = 20.sp,
                        lineHeight = 20.sp,
                        fontFamily = fontFamilyResource(SharedRes.fonts.poppins_semibold)
                    )
                )
            }
        }
    }
}

