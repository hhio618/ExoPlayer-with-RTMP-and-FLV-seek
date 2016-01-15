package com.google.android.exoplayer2.demo.player;


import android.net.Uri;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;

import net.butterflytv.rtmp_client.RtmpClient;

import java.io.IOException;

/**
 * Created by faraklit on 08.01.2016.
 */
public class RtmpDataSource implements DataSource {


    private final RtmpClient rtmpClient;
    private Uri uri;

    private RtmpDataSource() {
        rtmpClient = new RtmpClient();
    }

    @Override
    public Uri getUri() {
        return uri;
    }

    @Override
    public long open(DataSpec dataSpec) throws IOException {
        rtmpClient.open(dataSpec.uri.toString(), false);
        return C.LENGTH_UNSET;
    }

    @Override
    public void close() throws IOException {
        rtmpClient.close();
    }

    @Override
    public int read(byte[] buffer, int offset, int readLength) throws IOException {
        return rtmpClient.read(buffer, offset, readLength);

    }

    public static class Factory implements DataSource.Factory {
        @Override
        public DataSource createDataSource() {
            return new RtmpDataSource();
        }
    }
}
