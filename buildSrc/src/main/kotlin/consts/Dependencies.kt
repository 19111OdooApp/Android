/**
 * [Dependencies] предназначен для хранения всех зависимостей, которые нужны
 * в данном проекте
 *
 *
 * @author Ворожцов Михаил
 * @since 09.10.2022
 */
object Dependencies {

    object AndroidCore {
        private const val APPCOMPAT_VERSION = "1.5.1"
        private const val CORE_VERSION = "1.9.0"

        const val APPCOMPAT = "androidx.appcompat:appcompat:$APPCOMPAT_VERSION"
        const val CORE = "androidx.core:core-ktx:$CORE_VERSION"

        val ALL_DEPS = listOf(APPCOMPAT, CORE)
    }

    object Coroutines {
        private const val VERSION = "1.6.4"

        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
    }

    object Compose {

        // ===========================================================================================
        // BE VERY CAREFUL WHEN UPDATING COMPOSE DEPENDENCIES, BECAUSE THEY CAN USE DIFFERENT VERSION!
        // ===========================================================================================

        private const val COMPOSE_VERSION = "1.3.0"

        object Core {
            private const val ACTIVITY_COMPOSE_VERSION = "1.6.1"
            private const val CONSTRAINT_VERSION = "1.0.1"
            private const val MATERIAL3_VERSION = "1.0.0"

            const val UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"

            const val MATERIAL = "androidx.compose.material3:material3:$MATERIAL3_VERSION"
            const val MATERIAL_ICONS = "androidx.compose.material:material-icons-extended:$COMPOSE_VERSION"

            const val UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION"
            const val UI_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION" // debugImplementation

            const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:$ACTIVITY_COMPOSE_VERSION"

            const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout-compose:$CONSTRAINT_VERSION"

            val ALL_CORE_DEPS =
                listOf(UI, MATERIAL, MATERIAL_ICONS, UI_TOOLING_PREVIEW, ACTIVITY_COMPOSE, CONSTRAINT_LAYOUT)
            val ALL_CORE_DEBUG_DEPS = listOf(UI_TOOLING)
        }

        object Navigation {
            private const val VERSION = "2.5.3"

            const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:$VERSION"

            val ALL_NAVIGATION_DEPS = listOf(NAVIGATION_COMPOSE)
        }

        object Lifecycle {
            private const val LIFECYCLE_VERSION = "2.5.1"

            const val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_VERSION"
            const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:$LIFECYCLE_VERSION"

            val ALL_LIFECYCLE_DEPS = listOf(RUNTIME, VIEW_MODEL)
        }

        object Foundation {

            const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:$COMPOSE_VERSION"
            const val COMPOSE_FOUNDATION_LAYOUT = "androidx.compose.foundation:foundation-layout:$COMPOSE_VERSION"

            val ALL_FOUNDATION_DEPS = listOf(COMPOSE_FOUNDATION, COMPOSE_FOUNDATION_LAYOUT)
        }

        object RxJava {

            const val RX_JAVA = "androidx.compose.runtime:runtime-rxjava3:$COMPOSE_VERSION"

            val ALL_RXJAVA_DEPS = listOf(RX_JAVA)
        }

        object Test {

            const val UI_TEST = "androidx.compose.ui:ui-test-junit4:$COMPOSE_VERSION"
            const val UI_TEST_DEBUG = "androidx.compose.ui:ui-test-manifest:$COMPOSE_VERSION"
        }

        val ALL_DEPS =
            Core.ALL_CORE_DEPS + Lifecycle.ALL_LIFECYCLE_DEPS + Foundation.ALL_FOUNDATION_DEPS +
                RxJava.ALL_RXJAVA_DEPS + Navigation.ALL_NAVIGATION_DEPS
    }

    object Dagger {
        private const val VERSION = "2.44"

        const val ANDROID = "com.google.dagger:dagger-android:$VERSION"
        const val COMPILER = "com.google.dagger:dagger-compiler:$VERSION"
        const val PROCESSOR = "com.google.dagger:dagger-android-processor:$VERSION"

        val KAPT_DEPS = listOf(COMPILER, PROCESSOR)
    }

    object Logger {
        private const val TIMBER_VERSION = "5.0.1"

        const val TIMBER = "com.jakewharton.timber:timber:$TIMBER_VERSION"
    }

    object Retrofit {
        private const val VERSION = "2.9.0"

        const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:$VERSION"
        const val RETROFIT_DEPENDENCY = "com.squareup.retrofit2:retrofit:$VERSION"

        val ALL_DEPS = listOf(CONVERTER_GSON, RETROFIT_DEPENDENCY)
    }

    object Test {
        private const val JUNIT_VERSION = "1.1.3"
        private const val MOCKK_VERSION = "1.13.2"

        const val JUNIT = "androidx.test.ext:junit:$JUNIT_VERSION"
        const val TEST_JUNIT = "test-junit"
        const val MOCKK = "io.mockk:mockk:$MOCKK_VERSION"
    }

    object UI {
        private const val CONSTRAINT_LAYOUT_VERSION = "2.1.4"
        private const val MATERIAL_VERSION = "1.7.0"

        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:$CONSTRAINT_LAYOUT_VERSION"
        const val CORE = "com.google.android.material:material:$MATERIAL_VERSION"

        val ALL_DEPS = listOf(CONSTRAINT_LAYOUT, CORE)
    }

    object Firebase {
        private const val GOOGLE_SERVICES_VERSION = "4.3.14"
        private const val BOM_VERSION = "31.1.0"

        const val GOOGLE_SERVICES = "com.google.gms:google-services:$GOOGLE_SERVICES_VERSION"
        const val FIREBASE_BOM = "com.google.firebase:firebase-bom:$BOM_VERSION"
        const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
    }

    object Plugins {
        const val DETEKT_VERSION = "1.22.0-RC1"

        const val DETEKT_FORMATTING = "io.gitlab.arturbosch.detekt:detekt-formatting:$DETEKT_VERSION"
    }
}
