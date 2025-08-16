import SwiftUI
import shared

@main
struct iOSApp: App {
    let koin1 = KoinInit()
    init() {
        koin1.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
            PostScreen()
		}
	}
}
