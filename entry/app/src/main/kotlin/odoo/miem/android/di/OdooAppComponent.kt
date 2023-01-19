package odoo.miem.android.di

import android.content.Context
import dagger.Component
import odoo.miem.android.common.network.authorization.impl.di.AuthorizationInteractorApiProvider
import odoo.miem.android.core.dataStore.impl.di.DataStoreApiProvider
import odoo.miem.android.core.di.impl.ApiRegistry
import odoo.miem.android.core.di.impl.ApiResolver
import odoo.miem.android.core.jsonrpc.parser.impl.di.MoshiParserApiProvider
import odoo.miem.android.core.networkApi.authorization.impl.di.AuthorizationRepositoryApiProvider
import odoo.miem.android.core.networkApi.selectingModules.impl.di.SelectingModulesRepositoryApiProvider
import odoo.miem.android.core.platform.dependecies.DefaultPlatformDependencies
import odoo.miem.android.core.platform.dependecies.PlatformDependencies
import odoo.miem.android.core.platform.di.PlatformApiProvider
import odoo.miem.android.core.utils.di.RxApiProvider
import odoo.miem.android.feature.authorization.base.impl.di.AuthorizationScreenApiProvider
import odoo.miem.android.feature.moduleNotFound.impl.di.ModuleNotFoundScreenApiProvider
import odoo.miem.android.feature.selectingModules.impl.di.SelectingModulesScreenApiProvider

/**
 * [OdooAppComponent] - **Dagger** component, which is the parent component
 * for all  other components and provides [ApiResolver] with a common **Map** with all
 * **Api**
 *
 * Dependencies:
 *  - [PlatformDependencies] - request platform objects to general *DI graphg*
 *
 * Connected modules:
 *  - [AuthorizationRepositoryApiProvider] - to deliver the dependency of authorization repository
 *  - [AuthorizationScreenApiProvider] - to deliver the dependency of authorization screen
 *  - [AuthorizationInteractorApiProvider] - to deliver the dependency of authorization interactor
 *  - [DataStoreApiProvider] - to deliver the dependency of data store
 *  - [PlatformApiProvider] - to deliver the dependency of platform objects
 *  - [SelectingModulesScreenApiProvider] - to deliver the dependency of selecting modules screen
 *  - [ModuleNotFoundScreenApiProvider] - to deliver the dependency of module not found screen
 *
 * @author Vorozhtsov Mikhail
 */
@Component(
    dependencies = [
        PlatformDependencies::class,
    ],
    modules = [
        // Repositories
        AuthorizationRepositoryApiProvider::class,
        SelectingModulesRepositoryApiProvider::class,
        // Screens
        AuthorizationScreenApiProvider::class,
        SelectingModulesScreenApiProvider::class,
        ModuleNotFoundScreenApiProvider::class,
        // Interactors
        AuthorizationInteractorApiProvider::class,
        // Utils
        DataStoreApiProvider::class,
        MoshiParserApiProvider::class,
        PlatformApiProvider::class,
        RxApiProvider::class
    ]
)
interface OdooAppComponent {

    val apiResolver: ApiResolver
}

/**
 * Initialization of application's **DI graph**
 *
 * @param context is needed for initialization of [PlatformDependencies]
 */
fun Context.initApis(
    context: Context,
): OdooAppComponent = DaggerOdooAppComponent
    .builder()
    .platformDependencies(DefaultPlatformDependencies(context))
    .build()
    .also {
        ApiRegistry.init(it.apiResolver)
    }
