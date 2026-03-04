##Obfuscate Dictioonary
-obfuscationdictionary dictionary.txt
-classobfuscationdictionary dictionary.txt
-packageobfuscationdictionary dictionary.txt

# Code obfuscation
-keepclassmembers class com.flyvpnpro.main.** { <fields>; }
-keepclassmembers class com.flyvpnpro.main.MainActivity.** { <fields>; }
-keepclassmembers class com.flyvpnpro.main.MainApp { <fields>; }
-keepclassmembers class com.flyvpnpro.second.MainService { <fields>; }
-keepclassmembers class com.flyvpnpro.main.util.AESCrypt { <fields>; }
-keepclassmembers class com.flyvpnpro.second.util.securepreferences.model.HSCrypt1 { <fields>; }
-keepclassmembers class com.flyvpnpro.second.util.securepreferences.model.HSCrypt2 { <fields>; }
-keepclassmembers class com.flyvpnpro.second.util.securepreferences.model.HSCrypt3 { <fields>; }
-keepclassmembers class com.flyvpnpro.second.util.securepreferences.model.HSCrypt4 { <fields>; }
-keepclassmembers class com.flyvpnpro.second.util.securepreferences.model.HSCrypt5 { <fields>; }
-keepclassmembers class com.flyvpnpro.main.custom.** { <fields>; }
-keepclassmembers class com.flyvpnpro.second.** { <fields>; }
-keepclassmembers class com.flyvpnpro.main.util.ConfigUtil { <fields>; }
-keepclassmembers class com.flyvpnpro.main.util.ConfigUpdate { <fields>; }
-keepclassmembers class com.flyvpnpro.main.preference.** { <fields>; }

##Warning
-dontwarn com.android.org.conscrypt.SSLParametersImpl
-dontwarn javax.naming.InvalidNameException
-dontwarn javax.naming.NamingException
-dontwarn javax.naming.directory.Attribute
-dontwarn javax.naming.directory.Attributes
-dontwarn javax.naming.ldap.LdapName
-dontwarn javax.naming.ldap.Rdn
-dontwarn org.apache.harmony.xnet.provider.jsse.SSLParametersImpl
-dontwarn org.ietf.jgss.GSSContext
-dontwarn org.ietf.jgss.GSSCredential
-dontwarn org.ietf.jgss.GSSException
-dontwarn org.ietf.jgss.GSSManager
-dontwarn org.ietf.jgss.GSSName
-dontwarn org.ietf.jgss.Oid
-dontwarn sun.security.x509.X509Key
-dontwarn org.apache.**
-dontwarn org.apache.http.**
-dontwarn org.apache.http.client.protocol.ResponseContentEncoding
-dontwarn org.apache.http.impl.conn.ManagedHttpClientConnectionFactory

##Note
-dontnote android.net.http.*
-dontnote org.apache.commons.codec.**
-dontnote org.apache.http.**

##keep
-keepnames class com.google.android.gms.** {*;}
-keepattributes *Annotation*
-keepattributes Signature
-keep class com.** { *; }
-keep class net.** { *; }
-keep class org.** { *; }
-keep class android.** { *; }
-keep class org.conscrypt.** { *; }
-keepnames class net.i2p.crypto.eddsa.**
-keep interface org.apache.http.**
-keep public class org.apache.http.**{

public protected *;
}
-keep public class com.trilead.ssh2.** {

public protected *;
}
-keep class cn.pedant.** { *; }