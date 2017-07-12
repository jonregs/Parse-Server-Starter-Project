/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Application;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class StarterApplication extends Application {

    String TAG_SAVE_IN_BACKGROUND = "SaveInBackground";
    String TAG_GET_IN_BACKGROUND = "GetInBackground";

    String TWEET_TAG_SAVE_IN_BACKGROUND = "SaveInBackground";
    String TWEET_TAG_GET_IN_BACKGROUND = "GetInBackground";

  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    /*
    Login to Parse Server
    username: user
    password: j8yiiNOCeurK
     */
    Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
            .applicationId("8812ae35cb75fe6d52f018ec0a8add5339b999e8")
            .clientKey("dc0190dd5f7ca905b849a6ab18d292c4602dec93")
            .server("http://ec2-18-220-7-92.us-east-2.compute.amazonaws.com:80/parse/")
            .build()
    );

      /*
      ParseObject score = new ParseObject("Score");
      score.put("username", "Jonathan");
      score.put("score", 86);
      score.saveInBackground(new SaveCallback() {
          @Override
          public void done(ParseException e) {

              if (e == null) {

                  Log.i(TAG_SAVE_IN_BACKGROUND, "Successful");
              }
              else {

                  Log.i(TAG_SAVE_IN_BACKGROUND, "Failed. Error" + e.toString());

              }
          }
      });
      */

      /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

      query.getInBackground("lhPdEne3nI", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {

              if (e == null && object != null) {

                  object.put("score", 140);
                  object.saveInBackground();

                  Log.i(TAG_GET_IN_BACKGROUND, object.getString("username"));
                  Log.i(TAG_GET_IN_BACKGROUND, Integer.toString(object.getInt("score")));

              } else {

                  Log.i(TAG_GET_IN_BACKGROUND, "Fail");
              }
          }
      });*/

      ParseObject tweet = new ParseObject("Tweet");
      tweet.put("username", "Jonathan");
      tweet.put("tweet", "Hello everyone out there, this is a tweet message");
      tweet.saveInBackground(new SaveCallback() {
          @Override
          public void done(ParseException e) {

              if (e == null) {

                  Log.i(TWEET_TAG_SAVE_IN_BACKGROUND, "Success");
              } else
              {
                  Log.i(TWEET_TAG_SAVE_IN_BACKGROUND, "Fail" + e.toString());
              }
          }
      });

      ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");

      query.getInBackground("NseWyQkk5C", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {

              if (e == null && object != null) {

                  object.put("tweet", "This is not a tweet");
                  object.saveInBackground();

                  Log.i(TWEET_TAG_GET_IN_BACKGROUND, object.getString("username"));
                  Log.i(TWEET_TAG_GET_IN_BACKGROUND, object.getString("tweet"));
              }
          }
      });


    ParseUser.enableAutomaticUser();

    ParseACL defaultACL = new ParseACL();
    defaultACL.setPublicReadAccess(true);
    defaultACL.setPublicWriteAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);

  }
}
