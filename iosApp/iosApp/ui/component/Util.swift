//
//  Util.swift
//  iosApp
//
//  Created by Nachiketa Singh on 17/08/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

extension Image {
    init(sharedResource: shared.ImageResource) {
        self.init(sharedResource.assetImageName, bundle: sharedResource.bundle)
    }
}

extension Font {
    init(sharedResource: shared.FontResource, size: CGFloat = 14) {
        let uiFont = sharedResource.uiFont(withSize: size)
        self.init(uiFont)
    }
}

