/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trooper.ereader.controller;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AWSController {
    private final String accessKey = "AKIAUQOY5R7DJG74HBB4";
    private final String secretKey = "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";
    private final String bucketName = "mgp-reader";
    private final String separator = "/";
    private final String dot = ".";
    
    @GetMapping("/document/{year}/{edition}/{filename}/{extension}")
    @ResponseBody
    public ResponseEntity<byte[]> getS3Document(@PathVariable("year") String year, @PathVariable("edition") String edition, @PathVariable("filename") String filename, @PathVariable("extension") String extension) {
        try {
            BasicAWSCredentials creds = new BasicAWSCredentials(this.accessKey, this.secretKey);
            AmazonS3Client s3Client = (AmazonS3Client) AmazonS3ClientBuilder.standard()
                            .withCredentials(new AWSStaticCredentialsProvider(creds))
                            .withRegion(Regions.US_EAST_2)
                            .build();
            S3Object s3Object =  s3Client.getObject(bucketName, year + separator + edition + separator + filename + dot + extension);
            InputStream s3ObjectInputStream = s3Object.getObjectContent();
            byte[] byteArray = IOUtils.toByteArray(s3ObjectInputStream);
            return ResponseEntity.ok().body(byteArray);
        } catch (IOException ex) {
            Logger.getLogger(AWSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GetMapping("/image/{year}/{edition}")
    @ResponseBody
    public ResponseEntity<byte[]> getS3Image(@PathVariable("year") String year, @PathVariable("edition") String edition) {
        try {
            BasicAWSCredentials creds = new BasicAWSCredentials(this.accessKey, this.secretKey);
            AmazonS3Client s3Client = (AmazonS3Client) AmazonS3ClientBuilder.standard()
                            .withCredentials(new AWSStaticCredentialsProvider(creds))
                            .withRegion(Regions.US_EAST_2)
                            .build();
            S3Object s3Object =  s3Client.getObject(bucketName, year + separator + edition + separator + "caratula.png");
            InputStream s3ObjectInputStream = s3Object.getObjectContent();
            byte[] byteArray = IOUtils.toByteArray(s3ObjectInputStream);
            return ResponseEntity.ok().body(byteArray);
        } catch (IOException ex) {
            Logger.getLogger(AWSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @GetMapping("/audio/{year}/{edition}/{order}")
    @ResponseBody
    public ResponseEntity<byte[]> getS3Audio(@PathVariable("year") String year, @PathVariable("edition") String edition, @PathVariable("order") String order) {
        try {
            BasicAWSCredentials creds = new BasicAWSCredentials(this.accessKey, this.secretKey);
            AmazonS3Client s3Client = (AmazonS3Client) AmazonS3ClientBuilder.standard()
                            .withCredentials(new AWSStaticCredentialsProvider(creds))
                            .withRegion(Regions.US_EAST_2)
                            .build();
            S3Object s3Object =  s3Client.getObject(bucketName, year + separator + edition + separator + "audio"+ order + ".mp3");
            InputStream s3ObjectInputStream = s3Object.getObjectContent();
            byte[] byteArray = IOUtils.toByteArray(s3ObjectInputStream);
            return ResponseEntity.ok().body(byteArray);
        } catch (IOException ex) {
            Logger.getLogger(AWSController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
