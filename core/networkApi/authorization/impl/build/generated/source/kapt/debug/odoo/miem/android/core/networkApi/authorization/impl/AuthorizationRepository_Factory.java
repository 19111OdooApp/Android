// Generated by Dagger (https://dagger.dev).
package odoo.miem.android.core.networkApi.authorization.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AuthorizationRepository_Factory implements Factory<AuthorizationRepository> {
  @Override
  public AuthorizationRepository get() {
    return newInstance();
  }

  public static AuthorizationRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AuthorizationRepository newInstance() {
    return new AuthorizationRepository();
  }

  private static final class InstanceHolder {
    private static final AuthorizationRepository_Factory INSTANCE = new AuthorizationRepository_Factory();
  }
}
