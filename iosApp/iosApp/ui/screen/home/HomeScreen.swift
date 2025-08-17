//
//  HomeScreen.swift
//  iosApp
//
//  Created by Nachiketa Singh on 17/08/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct HomeScreen: View {
    @State private var showMenu = false
    @State private var selectedTab = 0
    
    var body: some View {
        ZStack {
            // MARK: - Main Screen
            VStack(spacing: 0) {
                
                // Top Bar
                HStack {
                    Button(action: {
                        withAnimation {
                            showMenu.toggle()
                        }
                    }) {
                        Image(systemName: "line.horizontal.3")
                            .font(.title)
                            .foregroundColor(.black)
                    }
                    
                    Spacer()
                    
                    Text(Strings().get(id: SharedRes.strings().welcome_message).localized())
                        .font(.headline)
                        .foregroundColor(.black)
                    
                    Spacer()
                    
                    // Empty space to balance hamburger
                    Image(systemName: "line.horizontal.3")
                        .opacity(0) // invisible but keeps alignment
                }
                .padding()
                .background(Color.gray.opacity(0.1))
                
                Spacer()
                
                // Body content
                Text("Selected Tab: \(selectedTab)")
                    .font(Font(sharedResource: SharedRes.fonts.shared.poppins_extrabold, size: 30))

                
                Image(sharedResource: SharedRes.images.shared.app_logo_60)
                    .resizable()
                    .frame(width: 80, height: 80)
                    .padding(.top, 20)

                Spacer()
                
                // Bottom Navigation Bar
                HStack {
                    Button(action: { selectedTab = 0 }) {
                        VStack {
                            Image(systemName: "house.fill")
                            Text("Home")
                        }
                    }
                    .frame(maxWidth: .infinity)
                    
                    Button(action: { selectedTab = 1 }) {
                        VStack {
                            Image(systemName: "magnifyingglass")
                            Text("Search")
                        }
                    }
                    .frame(maxWidth: .infinity)
                    
                    Button(action: { selectedTab = 2 }) {
                        VStack {
                            Image(systemName: "person.fill")
                            Text("Profile")
                        }
                    }
                    .frame(maxWidth: .infinity)
                }
                .padding()
                .background(Color.gray.opacity(0.1))
            }
            .disabled(showMenu)
            
            // MARK: - Side Menu
            if showMenu {
                HStack {
                    VStack(alignment: .leading, spacing: 20) {
                        Text("Menu")
                            .font(.largeTitle)
                            .bold()
                        
                        Button("Home") { selectedTab = 0 }
                        Button("Search") { selectedTab = 1 }
                        Button("Profile") { selectedTab = 2 }
                        
                        Spacer()
                    }
                    .padding()
                    .frame(width: 200, alignment: .leading)
                    .background(Color.white)
                    .shadow(radius: 5)
                    
                    Spacer()
                }
                .transition(.move(edge: .leading))
                Color.black.opacity(0.1)
                    .ignoresSafeArea()
                    .onTapGesture {
                        closeMenu()
                    }
            }
            
        }
        .background(Color.white.edgesIgnoringSafeArea(.all))
    }
    
    private func closeMenu() {
        withAnimation {
            showMenu = false
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen()
    }
}
