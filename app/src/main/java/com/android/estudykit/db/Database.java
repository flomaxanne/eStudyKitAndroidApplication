package com.android.estudykit.db;

/**
 * Created by Florence A. Pereira on 2/24/2017.
 */

public class Database {

    public static final class TaskTable {
        public static final String NAME = "tasks";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String CODE = "code";
            public static final String TITLE = "title";
            public static final String TYPE = "type";
            public static final String DATE = "due_date";
            public static final String COMPLETED = "completed";
        }
    }



    public static final class SubjectTable {
        public static final String NAME = "subjects";

        public static final class SubCols {
            public static final String UUID = "uuid";
            public static final String CODE = "code";
            public static final String TITLE = "title";
            public static final String DAY1 = "day1";
            public static final String DAY2 = "day2";
            public static final String DAY3 = "day3";

            public static final String TIME1START = "time1start";
            public static final String TIME1END = "time1end";

            public static final String TIME2START = "time2start";
            public static final String TIME2END = "time2end";


            public static final String TIME3START = "time3start";
            public static final String TIME3END = "time3end";


            public static final String LOCATION1 = "location1";
            public static final String LOCATION2 = "location2";
            public static final String LOCATION3 = "location3";


            public static final String LECTURER = "lecturer";

        }




    }










}
