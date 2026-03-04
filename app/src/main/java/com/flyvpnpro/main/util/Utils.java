package com.flyvpnpro.main.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.flyvpnpro.second.MainService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Random;


public class Utils
{
    public static String CurrentSMSVersion = "00";
    
	@SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    public static void copyToClipboard(Context context, String text) throws Exception {
		int sdk = android.os.Build.VERSION.SDK_INT;
            
		if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
                android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context
					.getSystemService(context.CLIPBOARD_SERVICE);
                clipboard.setText(text);
		}
		else {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context
					.getSystemService(context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData
					.newPlainText(
					"Message", text);
                clipboard.setPrimaryClip(clip);
         }
	}

  public static String[] sniffingList =
      new String[] {
        "mph.trunksku.apps.dexencryptor",
        "com.emanuelef.remote_capture",
        "com.guoshi.httpcanary",
        "com.ly.ljdvnzma",
        "app01.greyshirts.sslcapture",
        "com.evbadroid.proxymon",
        "app.greyshirts.sslcapture",
        "com.minhui.networkcapture",
        "com.minhui.networkcapture.pro",
        "com.packagesniffer.frtparlak",
        "com.minhui.wifianalyzer",
        "com.tdo.showbox",
        "com.nitroxenon.terrarium",
        "co.we.torrent",
        "com.spaceship.netprotect",
        "com.utorrent.client.pro",
        "com.utorrent.client",
        "com.xunlei.downloadprovider",
        "com.epic.app.iTorrent",
        "hu.bute.daai.amorg.drtorrent",
        "com.mobilityflow.torrent.prof",
        "com.brute.torrentolite",
        "com.nebula.swift",
        "tv.bitx.media",
        "com.DroiDownloader",
        "bitking.torrent.downloader",
        "org.transdroid.lite",
        "com.mobilityflow.tvp",
        "com.gabordemko.torrnado",
        "com.frostwire.android",
        "com.vuze.android.remote",
        "com.akingi.torrent",
        "com.utorrent.web",
        "com.paolod.torrentsearch2",
        "com.teeonsoft.ztorrent",
        "megabyte.tdm",
        "com.bittorrent.client.pro",
        "com.mobilityflow.torrent",
        "com.utorrent.client.pro",
        "com.bittorrent.client",
        "com.AndroidA.DroiDownloader",
        "com.indris.yifytorrents",
        "com.delphicoder.flud",
        "com.oidapps.bittorrent",
        "dwleee.torrentsearch",
        "com.vuze.torrent.downloader",
        "megabyte.dm",
        "com.fgrouptech.kickasstorrents",
        "com.utorrent.client",
        "com.jrummyapps.rootbrowser.classic",
        "hu.tagsoft.ttorrent.lite",
        "bin.mt.plus",
        "bin.mt.plus.canary",
        "player.normal.np",
        "com.adguard.android.contentblocker",
        "com.minhui.wifianalayzer",
        "appisniffer.online",
        "com.aconno.blesniffer",
        "com.packagesniffer.frtparlak",
        "com.guoshi.httpcanary",
        "app.greyshirts.sslcapture",
        "jp.co.taosoftware.android.packetcapture",
        "com.minhui.networkcapture",
        "in.gopalakrishnareddy.torrent",
        "com.delphicoder.flud",
        "hu.tagsoft.ttorrent.lite",
        "co.we.torrent",
        "com.mobilityflow.torrent",
        "com.tordown.torrentsave",
        "com.marutigroup.downtor",
        "com.akingi.torrent",
        "com.gamemalt.streamtorrentvideos",
        "com.down.move.films",
        "com.nest.logix.metorrent.hd.movies.torrent",
        "torrentvillalite.romreviewer.com",
        "com.easelifeapps.torrz",
        "com.samp.money.carinsurance",
        "com.mediaget.android",
        "com.vuze.torrent.downloader",
        "com.biglybt.android.client",
        "com.foossi.bitcloud",
        "com.gmail.heagoo.apkeditor.pro",
        "download.torrent.magnet"
      };

	public static PackageInfo getAppInfo(Context context){
		try {
			return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
		} catch (PackageManager.NameNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String readFromAssets(Context context, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));

        // do reading, usually loop until end of file reading
        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        while (mLine != null) {
            sb.append(mLine + '\n'); // process line
            mLine = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }
    
    public static String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in));
            char[] buff = new char[1024];
            while (true) {
                int read = reader.read(buff, 0, buff.length);
                if (read <= 0) {
                    break;
                }
                sb.append(buff, 0, read);
            }
        } catch (Exception e) {

        }
        return sb.toString();
    }
	
	public static void hideKeyboard(Activity activity) {
		InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
		
        if (activity.getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (activity.getCurrentFocus() != null)
                inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
					0);
        }
    }
	
	public static void exitAll(Activity activity) {
		Intent stopTunnel = new Intent(MainService.TUNNEL_SSH_STOP_SERVICE);
		LocalBroadcastManager.getInstance(activity)
			.sendBroadcast(stopTunnel);

		if (Build.VERSION.SDK_INT >= 16) {
			activity.finishAffinity();
		}

		System.exit(0);
	}
    public static int nextIntInRange(int min, int max, Random rng) {
        if (min > max) {
            throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
        }
        int diff = max - min;
        if (diff >= 0 && diff != Integer.MAX_VALUE) {
            return (min + rng.nextInt(diff + 1));
        }
        int i;
        do {
            i = rng.nextInt();
        } while (i < min || i > max);
        return i;
	}
}
