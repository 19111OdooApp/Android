package odoo.miem.android.di

import android.content.Context
import dagger.Component
import odoo.miem.android.common.network.authorization.impl.di.AuthorizationInteractorApiProvider
import odoo.miem.android.common.network.selectingModules.impl.di.SelectingModulesInteractorApiProvider
import odoo.miem.android.core.dataStore.impl.di.DataStoreApiProvider
import odoo.miem.android.core.di.impl.ApiRegistry
import odoo.miem.android.core.di.impl.ApiResolver
import odoo.miem.android.core.firebaseDatabase.impl.di.FirebaseDatabaseApiProvider
import odoo.miem.android.core.jsonrpc.converter.impl.di.MoshiSerializerApiProvider
import odoo.miem.android.core.networkApi.authorization.impl.di.AuthorizationRepositoryApiProvider
import odoo.miem.android.core.networkApi.firebaseRemoteConfig.impl.di.FirebaseRemoteConfigApiProvider
import odoo.miem.android.core.networkApi.userInfo.impl.di.UserInfoRepositoryApiProvider
import odoo.miem.android.core.networkApi.userModules.impl.di.UserModulesRepositoryApiProvider
import odoo.miem.android.core.platform.dependecies.DefaultPlatformDependencies
import odoo.miem.android.core.platform.dependecies.PlatformDependencies
import odoo.miem.android.core.platform.di.PlatformApiProvider
import odoo.miem.android.core.utils.di.RxApiProvider
import odoo.miem.android.feature.authorization.base.impl.di.AuthorizationScreenApiProvider
import odoo.miem.android.feature.crm.impl.di.CrmScreenApiProvider
import odoo.miem.android.feature.details.impl.di.DetailsScreenApiProvider
import odoo.miem.android.feature.moduleNotFound.impl.di.ModuleNotFoundScreenApiProvider
import odoo.miem.android.feature.recruitment.impl.di.RecruitmentScreenApiProvider
import odoo.miem.android.feature.selectingModules.impl.di.SelectingModulesScreenApiProvider
import odoo.miem.android.feature.userProfile.impl.di.UserProfileScreenApiProvider

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
 *  - [UserInfoRepositoryApiProvider] - to deliver the dependency of user info repository
 *  - [UserModulesRepositoryApiProvider] - to deliver the dependency of user modules repository
 *  - [FirebaseRemoteConfigApiProvider] - to deliver the dependency of Firebase Remote Config,
 *  - [FirebaseDatabaseApiProvider] - to deliver the dependency of Firebase Firestore and Storage
 *
 *  - [AuthorizationScreenApiProvider] - to deliver the dependency of authorization screen
 *  - [SelectingModulesScreenApiProvider] - to deliver the dependency of selecting modules screen
 *  - [ModuleNotFoundScreenApiProvider] - to deliver the dependency of module not found screen
 *  - [RecruitmentScreenApiProvider] - to deliver the dependency of recruitment module
 *  - [DetailsScreenApiProvider] - to deliver the dependency of screen with details for recruitment like module
 *  - [CrmScreenApiProvider] - to deliver the dependency of crm module
 *  - [UserProfileScreenApiProvider] - to deliver the dependency of user profile module
 *
 *  - [AuthorizationInteractorApiProvider] - to deliver the dependency of authorization interactor
 *  - [SelectingModulesInteractorApiProvider] - to deliver the dependency of selection modules interactor
 *
 *  - [DataStoreApiProvider] - to deliver the dependency of data store
 *  - [PlatformApiProvider] - to deliver the dependency of platform objects
 *  - [SelectingModulesScreenApiProvider] - to deliver the dependency of selecting modules screen
 *  - [ModuleNotFoundScreenApiProvider] - to deliver the dependency of module not found screen
 *  - [RecruitmentScreenApiProvider] - to deliver the dependency of recruitment module screen
 *  - [RxApiProvider] - to deliver the dependency of  RX chains utils
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
        UserInfoRepositoryApiProvider::class,
        UserModulesRepositoryApiProvider::class,
        FirebaseRemoteConfigApiProvider::class,
        FirebaseDatabaseApiProvider::class,

        // Screens
        AuthorizationScreenApiProvider::class,
        SelectingModulesScreenApiProvider::class,
        ModuleNotFoundScreenApiProvider::class,
        RecruitmentScreenApiProvider::class,
        DetailsScreenApiProvider::class,
        CrmScreenApiProvider::class,
        UserProfileScreenApiProvider::class,

        // Interactors
        AuthorizationInteractorApiProvider::class,
        SelectingModulesInteractorApiProvider::class,

        // Utils
        DataStoreApiProvider::class,
        MoshiSerializerApiProvider::class,
        PlatformApiProvider::class,
        RxApiProvider::class,
        SelectingModulesScreenApiProvider::class,
        ModuleNotFoundScreenApiProvider::class,
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
