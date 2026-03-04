package com.flyvpnpro.second.util.securepreferences;

import android.content.Context;

import com.flyvpnpro.main.util.AESCrypt;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

/** Created by: KervzCodes Date Crated: 08/10/2020 Project: SocksHttp-master (ENGLISH) */

public class FileUtil {

  Context context;

  public static final String PASSWORD =
      new String(
          android.util.Base64.decode(
              new String(
                      android.util.Base64.decode(
                          new Object() {
                            int HSDevTeam;

                            public String toString() {
                              byte[] buf = new byte[56];
                              HSDevTeam = -1096114091;
                              buf[0] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = 1799969817;
                              buf[1] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 211200213;
                              buf[2] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = -1218979420;
                              buf[3] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 1919651809;
                              buf[4] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = -1037472334;
                              buf[5] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = -362261824;
                              buf[6] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = -946718386;
                              buf[7] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = -1891292674;
                              buf[8] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = 191787648;
                              buf[9] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = -1816309870;
                              buf[10] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = 1750336720;
                              buf[11] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = 1612022594;
                              buf[12] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = -1918709379;
                              buf[13] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 455471430;
                              buf[14] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = -1931041696;
                              buf[15] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = 1680498475;
                              buf[16] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 795250863;
                              buf[17] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = 2058208130;
                              buf[18] = (byte) (HSDevTeam >>> 3);
                              HSDevTeam = 271044923;
                              buf[19] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 1581942937;
                              buf[20] = (byte) (HSDevTeam >>> 11);
                              HSDevTeam = 774657623;
                              buf[21] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = 489163120;
                              buf[22] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = 81565022;
                              buf[23] = (byte) (HSDevTeam >>> 14);
                              HSDevTeam = 1756150351;
                              buf[24] = (byte) (HSDevTeam >>> 13);
                              HSDevTeam = 776214811;
                              buf[25] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = 679720974;
                              buf[26] = (byte) (HSDevTeam >>> 7);
                              HSDevTeam = -122729874;
                              buf[27] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = 630597493;
                              buf[28] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = -1305656673;
                              buf[29] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = -1600312610;
                              buf[30] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -1734217902;
                              buf[31] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = 1444754457;
                              buf[32] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 1736594739;
                              buf[33] = (byte) (HSDevTeam >>> 8);
                              HSDevTeam = -1247513585;
                              buf[34] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = -1829040973;
                              buf[35] = (byte) (HSDevTeam >>> 22);
                              HSDevTeam = -1768596055;
                              buf[36] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = 1210075148;
                              buf[37] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 1692979058;
                              buf[38] = (byte) (HSDevTeam >>> 24);
                              HSDevTeam = 1862396291;
                              buf[39] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = 1125765514;
                              buf[40] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = -1708922132;
                              buf[41] = (byte) (HSDevTeam >>> 19);
                              HSDevTeam = 596296877;
                              buf[42] = (byte) (HSDevTeam >>> 4);
                              HSDevTeam = 1665462131;
                              buf[43] = (byte) (HSDevTeam >>> 12);
                              HSDevTeam = 1286774597;
                              buf[44] = (byte) (HSDevTeam >>> 21);
                              HSDevTeam = -179733352;
                              buf[45] = (byte) (HSDevTeam >>> 20);
                              HSDevTeam = -1045886132;
                              buf[46] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = 1762204879;
                              buf[47] = (byte) (HSDevTeam >>> 2);
                              HSDevTeam = 1800682916;
                              buf[48] = (byte) (HSDevTeam >>> 16);
                              HSDevTeam = 618898063;
                              buf[49] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = -1178518757;
                              buf[50] = (byte) (HSDevTeam >>> 18);
                              HSDevTeam = -191542698;
                              buf[51] = (byte) (HSDevTeam >>> 10);
                              HSDevTeam = -1264499046;
                              buf[52] = (byte) (HSDevTeam >>> 17);
                              HSDevTeam = 1286124924;
                              buf[53] = (byte) (HSDevTeam >>> 15);
                              HSDevTeam = -12387205;
                              buf[54] = (byte) (HSDevTeam >>> 1);
                              HSDevTeam = -1890590461;
                              buf[55] = (byte) (HSDevTeam >>> 22);
                              return new String(buf);
                            }
                          }.toString().getBytes(),
                          android.util.Base64.DEFAULT))
                  .getBytes(),
              android.util.Base64.DEFAULT));

  public static final String HWIDPASS =
      new String(
          new Object() {
            int HSDev_Team$$$;

            public String toString() {
              byte[] ugh = new byte[12];
              HSDev_Team$$$ = 1810230469;
              ugh[0] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = 1451322768;
              ugh[1] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = -1607659713;
              ugh[2] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = 1316595329;
              ugh[3] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = 1388686852;
              ugh[4] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = 1591856725;
              ugh[5] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = 551054821;
              ugh[6] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = -132626786;
              ugh[7] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = 1526820202;
              ugh[8] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = -319198150;
              ugh[9] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = -347042423;
              ugh[10] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              HSDev_Team$$$ = -439399120;
              ugh[11] =
                  (byte)
                      (HSDev_Team$$$
                          >>> Integer.valueOf(
                              (new Object() {
                                int
                                    HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh;

                                public String toString() {
                                  byte[]
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€ =
                                          new byte[2];
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      -846088739;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          0] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 22);
                                  HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh =
                                      613358785;
                                  ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€[
                                          1] =
                                      (byte)
                                          (HSDevTeam_HSDevTeam_HSDevTeam_HSDevTeamHSDevTeam_HSDevTeam_HSDevTeam_HSDevTeam$$$$$$$$$$$$$$$€¥€€$€€¥€¥€¥€¥€€€bleehebhelhebujbbhebduwjnzkwjxjkekxkwinxjwjjeixjjejxjwkkxjwjxneujejejBleehehhehehehehhehehehhehehehehheheheh
                                              >>> 7);
                                  return new String(
                                      ooOooOoOoOoOoooOoiiiIiiiiillllolololololololololololulululululululuoulpuloyluoykeiiwhxuwjzjkwksmwkxbhehsniwnsjwjjwiwisjiwjduekkzkwbziwkxhiwnxueolahauREMODMGAULOLLOLLLLLLWLAHAHAHAHHAHAHAHAHHAHA₱₱₱₱$¥$¥$¥$¥$¥€¥€¥€);
                                }
                              }.toString())));
              return new String(ugh);
            }
          }.toString());

  public FileUtil(Context context) {
    this.context = context;
  }

  public String geNote() {
    try {
      String releaseNote = getJSONConfig().getString("FLYReleaseNotes");
      return releaseNote;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getVersion() {
    try {
      String version = getJSONConfig().getString("FLYVersion");
      return version;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public JSONArray getServersArray() {
    try {
      if (getJSONConfig() != null) {
        JSONArray array = getJSONConfig().getJSONArray("FLYServers");
        return array;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList getNetworkSSLArray(ArrayList arraylist) {
    try {
      if (getJSONConfig() != null) {
        JSONArray array = getJSONConfig().getJSONArray("Networks");
        JSONArray jarr2 = array.getJSONObject(0).getJSONArray("SSL");
        for (int i = 0; i < jarr2.length(); i++) {
          JSONObject obj = jarr2.getJSONObject(i);
          arraylist.add(obj.getString("Name"));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public ArrayList getNetworkSSHArray(ArrayList arraylist) {
    try {
      if (getJSONConfig() != null) {
        JSONArray array = getJSONConfig().getJSONArray("Networks");
        JSONArray jarr2 = array.getJSONObject(0).getJSONArray("SSH");
        for (int i = 0; i < jarr2.length(); i++) {
          JSONObject obj = jarr2.getJSONObject(i);
          arraylist.add(obj.getString("Name"));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public JSONArray getNetworksArray() {
    try {
      if (getJSONConfig() != null) {
        JSONArray array = getJSONConfig().getJSONArray("Networks");
        return array;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public boolean versionCompare(String NewVersion, String OldVersion) {
    String[] vals1 = NewVersion.split("\\.");
    String[] vals2 = OldVersion.split("\\.");
    int i = 0;

    // set index to first non-equal ordinal or length of shortest version string
    while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])) {
      i++;
    }
    // compare first non-equal ordinal number
    if (i < vals1.length && i < vals2.length) {
      int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
      return Integer.signum(diff) > 0;
    }

    // the strings are equal or one string is a substring of the other
    // e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
    return Integer.signum(vals1.length - vals2.length) > 0;
  }

  private JSONObject getJSONConfig() {
    try {
      File file = new File(context.getFilesDir(), "flyvpnpro.json");
      if (file.exists()) {
        String json_file = readStream(new FileInputStream(file));
        String json = AESCrypt.decrypt(PASSWORD, json_file);
        return new JSONObject(json);
      } else {
        InputStream inputStream = context.getAssets().open("flyvpnpro/flyvpnpro.json");
        String json = AESCrypt.decrypt(PASSWORD, readStream(inputStream));
        return new JSONObject(json);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private String readStream(InputStream in) {
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
}

