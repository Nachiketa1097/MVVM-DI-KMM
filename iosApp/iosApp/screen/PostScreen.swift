//
//  PostScreen.swift
//  iosApp
//
//  Created by Nachiketa Singh on 12/08/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PostScreen: View {
    @StateObject private var vm = PostViewModel()

    var body: some View {
        VStack(alignment: .leading) {
//            Text(MR.strings().my_string.desc().localized())
//                .font(.title)
//                .padding(.bottom, 8)
//            
//            Image(uiImage: MR.images().logo.toUIImage()!)
//                        .resizable()
//                        .frame(width: 100, height: 100)

            ForEach(vm.product, id: \.id) { post in
                Text(post.title ?? "")
                    .font(.body)
                    .padding(.bottom, 4)
            }
        }
        .onAppear{
            print("POST LIST")
            print(vm.product)
        }
        .padding()
    }
}
