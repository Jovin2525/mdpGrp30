package com.example.branchmdpgrp30;
import java.util.HashMap;
import java.util.Map;

public class Helper {
  protected static final String ROBOT = "ROBOT";
  protected static final String TARGET = "TARGET";
  protected static final String STATUS = "STATUS";
  protected static final String COMMAND = "C";

  protected static Map<String, Integer> resources = new HashMap<String, Integer>() {
    {
      put("car", R.drawable.robot_icon);

      put("o1n", R.drawable.obstacle_1_n);
      put("o1e", R.drawable.obstacle_1_e);
      put("o1s", R.drawable.obstacle_1_s);
      put("o1w", R.drawable.obstacle_1_w);

      put("o2n", R.drawable.obstacle_2_n);
      put("o2e", R.drawable.obstacle_2_e);
      put("o2s", R.drawable.obstacle_2_s);
      put("o2w", R.drawable.obstacle_2_w);

      put("o3n", R.drawable.obstacle_3_n);
      put("o3e", R.drawable.obstacle_3_e);
      put("o3s", R.drawable.obstacle_3_s);
      put("o3w", R.drawable.obstacle_3_w);

      put("o4n", R.drawable.obstacle_4_n);
      put("o4e", R.drawable.obstacle_4_e);
      put("o4s", R.drawable.obstacle_4_s);
      put("o4w", R.drawable.obstacle_4_w);

      put("o5n", R.drawable.obstacle_5_n);
      put("o5e", R.drawable.obstacle_5_e);
      put("o5s", R.drawable.obstacle_5_s);
      put("o5w", R.drawable.obstacle_5_w);

      put("o6n", R.drawable.obstacle_6_n);
      put("o6e", R.drawable.obstacle_6_e);
      put("o6s", R.drawable.obstacle_6_s);
      put("o6w", R.drawable.obstacle_6_w);

      put("o7n", R.drawable.obstacle_7_n);
      put("o7e", R.drawable.obstacle_7_e);
      put("o7s", R.drawable.obstacle_7_s);
      put("o7w", R.drawable.obstacle_7_w);

      put("o8n", R.drawable.obstacle_8_n);
      put("o8e", R.drawable.obstacle_8_e);
      put("o8s", R.drawable.obstacle_8_s);
      put("o8w", R.drawable.obstacle_8_w);

      put("11", R.drawable.number_1);
      put("11n", R.drawable.number_1_n);
      put("11e", R.drawable.number_1_e);
      put("11s", R.drawable.number_1_s);
      put("11w", R.drawable.number_1_w);

      put("12", R.drawable.number_2);
      put("12n", R.drawable.number_2_n);
      put("12e", R.drawable.number_2_e);
      put("12s", R.drawable.number_2_s);
      put("12w", R.drawable.number_2_w);

      put("13", R.drawable.number_3);
      put("13n", R.drawable.number_3_n);
      put("13e", R.drawable.number_3_e);
      put("13s", R.drawable.number_3_s);
      put("13w", R.drawable.number_3_w);

      put("14", R.drawable.number_4);
      put("14n", R.drawable.number_4_n);
      put("14e", R.drawable.number_4_e);
      put("14s", R.drawable.number_4_s);
      put("14w", R.drawable.number_4_w);

      put("15", R.drawable.number_5);
      put("15n", R.drawable.number_5_n);
      put("15e", R.drawable.number_5_e);
      put("15s", R.drawable.number_5_s);
      put("15w", R.drawable.number_5_w);

      put("16", R.drawable.number_6);
      put("16n", R.drawable.number_6_n);
      put("16e", R.drawable.number_6_e);
      put("16s", R.drawable.number_6_s);
      put("16w", R.drawable.number_6_w);

      put("17", R.drawable.number_7);
      put("17n", R.drawable.number_7_n);
      put("17e", R.drawable.number_7_e);
      put("17s", R.drawable.number_7_s);
      put("17w", R.drawable.number_7_w);

      put("18", R.drawable.number_8);
      put("18n", R.drawable.number_8_n);
      put("18e", R.drawable.number_8_e);
      put("18s", R.drawable.number_8_s);
      put("18w", R.drawable.number_8_w);

      put("19", R.drawable.number_9);
      put("19n", R.drawable.number_9_n);
      put("19e", R.drawable.number_9_e);
      put("19s", R.drawable.number_9_s);
      put("19w", R.drawable.number_9_w);

      put("20", R.drawable.alphabet_a);
      put("20n", R.drawable.alphabet_a_n);
      put("20e", R.drawable.alphabet_a_e);
      put("20s", R.drawable.alphabet_a_s);
      put("20w", R.drawable.alphabet_a_w);

      put("21", R.drawable.alphabet_b);
      put("21n", R.drawable.alphabet_b_n);
      put("21e", R.drawable.alphabet_b_e);
      put("21s", R.drawable.alphabet_b_s);
      put("21w", R.drawable.alphabet_b_w);

      put("22", R.drawable.alphabet_c);
      put("22n", R.drawable.alphabet_c_n);
      put("22e", R.drawable.alphabet_c_e);
      put("22s", R.drawable.alphabet_c_s);
      put("22w", R.drawable.alphabet_c_w);

      put("23", R.drawable.alphabet_d);
      put("23n", R.drawable.alphabet_d_n);
      put("23e", R.drawable.alphabet_d_e);
      put("23s", R.drawable.alphabet_d_s);
      put("23w", R.drawable.alphabet_d_w);

      put("24", R.drawable.alphabet_e);
      put("24n", R.drawable.alphabet_e_n);
      put("24e", R.drawable.alphabet_e_e);
      put("24s", R.drawable.alphabet_e_s);
      put("24w", R.drawable.alphabet_e_w);

      put("25", R.drawable.alphabet_f);
      put("25n", R.drawable.alphabet_f_n);
      put("25e", R.drawable.alphabet_f_e);
      put("25s", R.drawable.alphabet_f_s);
      put("25w", R.drawable.alphabet_f_w);

      put("26", R.drawable.alphabet_g);
      put("26n", R.drawable.alphabet_g_n);
      put("26e", R.drawable.alphabet_g_e);
      put("26s", R.drawable.alphabet_g_s);
      put("26w", R.drawable.alphabet_g_w);

      put("27", R.drawable.alphabet_h);
      put("27n", R.drawable.alphabet_h_n);
      put("27e", R.drawable.alphabet_h_e);
      put("27s", R.drawable.alphabet_h_s);
      put("27w", R.drawable.alphabet_h_w);

      put("28", R.drawable.alphabet_s);
      put("28n", R.drawable.alphabet_s_n);
      put("28e", R.drawable.alphabet_s_e);
      put("28s", R.drawable.alphabet_s_s);
      put("28w", R.drawable.alphabet_s_w);

      put("29", R.drawable.alphabet_t);
      put("29n", R.drawable.alphabet_t_n);
      put("29e", R.drawable.alphabet_t_e);
      put("29s", R.drawable.alphabet_t_s);
      put("29w", R.drawable.alphabet_t_w);

      put("30", R.drawable.alphabet_u);
      put("30n", R.drawable.alphabet_u_n);
      put("30e", R.drawable.alphabet_u_e);
      put("30s", R.drawable.alphabet_u_s);
      put("30w", R.drawable.alphabet_u_w);

      put("31", R.drawable.alphabet_v);
      put("31n", R.drawable.alphabet_v_n);
      put("31e", R.drawable.alphabet_v_e);
      put("31s", R.drawable.alphabet_v_s);
      put("31w", R.drawable.alphabet_v_w);

      put("32", R.drawable.alphabet_w);
      put("32n", R.drawable.alphabet_w_n);
      put("32e", R.drawable.alphabet_w_e);
      put("32s", R.drawable.alphabet_w_s);
      put("32w", R.drawable.alphabet_w_w);

      put("33", R.drawable.alphabet_x);
      put("33n", R.drawable.alphabet_x_n);
      put("33e", R.drawable.alphabet_x_e);
      put("33s", R.drawable.alphabet_x_s);
      put("33w", R.drawable.alphabet_x_w);

      put("34", R.drawable.alphabet_y);
      put("34n", R.drawable.alphabet_y_n);
      put("34e", R.drawable.alphabet_y_e);
      put("34s", R.drawable.alphabet_y_s);
      put("34w", R.drawable.alphabet_y_w);

      put("35", R.drawable.alphabet_z);
      put("35n", R.drawable.alphabet_z_n);
      put("35e", R.drawable.alphabet_z_e);
      put("35s", R.drawable.alphabet_z_s);
      put("35w", R.drawable.alphabet_z_w);

      put("36", R.drawable.arrow_up);
      put("36n", R.drawable.arrow_up_n);
      put("36e", R.drawable.arrow_up_e);
      put("36w", R.drawable.arrow_up_w);
      put("36s", R.drawable.arrow_up_s);

      put("37", R.drawable.arrow_down);
      put("37n", R.drawable.arrow_down_n);
      put("37e", R.drawable.arrow_down_e);
      put("37w", R.drawable.arrow_down_w);
      put("37s", R.drawable.arrow_down_s);

      put("39", R.drawable.arrow_left);
      put("39n", R.drawable.arrow_left_n);
      put("39e", R.drawable.arrow_left_e);
      put("39w", R.drawable.arrow_left_w);
      put("39s", R.drawable.arrow_left_s);

      put("38", R.drawable.arrow_right);
      put("38n", R.drawable.arrow_right_n);
      put("38e", R.drawable.arrow_right_e);
      put("38s", R.drawable.arrow_right_s);
      put("38w", R.drawable.arrow_right_w);

      put("40", R.drawable.circle);
      put("40n", R.drawable.circle);
      put("40s", R.drawable.circle);
      put("40e", R.drawable.circle);
      put("40w", R.drawable.circle);

      put("41", R.drawable.bullseye);
      put("42", R.drawable.yellow_question_mark);
      put("43", R.drawable.red_question_mark);
    }
  };
}
