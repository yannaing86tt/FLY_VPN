package com.flyvpnpro.second.config;

public interface SettingsConstants
{

  // Geral
  public static final String 
      MODO_DEBUG_KEY = "modeDebug",
      MODO_NOTURNO_KEY = "modeNight",
      BLOQUEAR_ROOT_KEY = "blockRoot",
      AUTO_CLEAR_LOGS_KEY = "autoClearLogs",
      HIDE_LOG_KEY = "hideLog",
      VIBRATE = "vibrate",
      // IDIOMA_KEY = "idioma",
      TETHERING_SUBNET = "tetherSubnet",
      DISABLE_DELAY_KEY = "disableDelaySSH",
      MAXIMO_THREADS_KEY = "numberMaxThreadSocks",
      FILTER_APPS = "filterApps",
      FILTER_BYPASS_MODE = "filterBypassMode",
      FILTER_APPS_LIST = "filterAppsList",
      PROXY_IP_KEY = "proxyRemoto",
      PROXY_PORTA_KEY = "proxyRemotoPorta",
      CUSTOM_PAYLOAD_KEY = "proxyPayload",
      PROXY_USAR_DEFAULT_PAYLOAD = "usarDefaultPayload",
      PROXY_USAR_AUTENTICACAO_KEY = "usarProxyAutenticacao";
      
  public static final String 
      CONFIG_PROTEGER_KEY = "protegerConfig",
      CONFIG_MENSAGEM_KEY = "mensagemConfig",
      CONFIG_VALIDADE_KEY = "validadeConfig",
      CONFIG_MENSAGEM_EXPORTAR_KEY = "mensagemConfigExport",
      CONFIG_INPUT_PASSWORD_KEY = "inputPassword";

  // Vpn
  public static final String 
      DNSTYPE_KEY = "DNSType",
      DNSFORWARD_KEY = "dnsForward",
      DNSRESOLVER_KEY1 = "dnsResolver1",
      DNSRESOLVER_KEY2 = "dnsResolver2",
      BYPASS_KEY = "bypassKey",
      UDPFORWARD_KEY = "udpForward",
      UDPRESOLVER_KEY = "udpResolver",
      URLCHECKUSER_KEY = "urlcheckuser";

  // SSH
  public static final String SERVIDOR_KEY = "sshServer",
      SERVIDOR_PORTA_KEY = "sshPort",
      VIPUSER_KEY = "VipUser",
      VIPPASS_KEY = "VipPass",
      USUARIO_KEY = "sshUser",
      SENHA_KEY = "sshPass",
      KEYPATH_KEY = "keyPath",
      CHAVE_KEY = "chaveKey",
      DNS_KEY = "dnsKey",
      NAMESERVER_KEY = "serverNameKey",
      SSH_COMPRESSION = "data_compression",
      WAKELOCK_KEY = "wakelock",
      PINGER_KEY = "pingerSSH",
      AUTO_PINGER = "auto_ping",
      PINGER = "ping_server",
      PORTA_LOCAL_KEY = "sshPortaLocal",
      CUSTOM_SNI = "wsPayload";

  // DNS TYPE
  public static final String 
      DNS_DEFAULT_KEY = "DNS (Default DNS)",
      DNS_GOOGLE_KEY = "DNS (Google DNS)",
      DNS_CUSTOM_KEY = "DNS (Custom DNS)";

  public static final String
	  PAYLOAD_DEFAULT = "CONNECT [host_port] [protocol][crlf][crlf]";

  // Tunnel Type
  public static final String 
      TUNNELTYPE_KEY = "tunnelType",
      TUNNEL_TYPE_SSH_DIRECT = "sshDirect",
      TUNNEL_TYPE_SSH_PROXY = "sshProxy",
      TUNNEL_TYPE_SSH_SSLTUNNEL = "sshSslTunnel",
      TUNNEL_TYPE_SSL_PAYLOAD = "sslpay";
      
  public static final int 
      bTUNNEL_TYPE_SSH_DIRECT = 1,
      bTUNNEL_TYPE_SSH_PROXY = 2,
      bTUNNEL_TYPE_SSH_SSL = 3,
      bTUNNEL_TYPE_PAY_SSL = 4,
      bTUNNEL_TYPE_SLOWDNS = 5,
      bTUNNEL_TYPE_SSL_RP = 6,
      bTUNNEL_TYPE_UDP = 7;
}
