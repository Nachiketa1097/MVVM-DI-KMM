//
//  PostViewModel.swift
//  iosApp
//
//  Created by Nachiketa Singh on 12/08/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import shared

class PostViewModel: ObservableObject {
    private let viewModel: shared.CommonViewModel
    @Published var product: [Product] = []

    init() {
//         Get instance from Koin DI
        let helper = IOSDIHelper()

        self.viewModel = helper.commonViewModel

        self.viewModel.watchPosts { [weak self] products in
            self?.product = products
        }

        // Load data
        self.viewModel.loadProducts()
    }
}
