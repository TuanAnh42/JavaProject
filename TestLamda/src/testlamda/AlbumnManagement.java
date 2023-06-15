/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author std
 */
public class AlbumnManagement {

    public List<Albumn> initiateAlbumnList() {
        List<Artist> artists1 = Arrays.asList(new Artist("MTP"), new Artist("My Tam"));
        List<Artist> artists2 = Arrays.asList(new Artist("BlackPink"), new Artist("Amee"));
        List<Track> tracks1 = Arrays.asList(new Track("Noi Nay Co Anh", 308000000), new Track("Uoc Gi", 10000000));
        List<Track> tracks2 = Arrays.asList(new Track("How You Like That ", 1100000000), new Track("Anh Danh Roi Nguoi Yeu Nay", 48000000));
        List<Albumn> listAlbumn = Arrays.asList(new Albumn("Albumn Nam Ay", tracks1, artists1), new Albumn("Albumn Hien Tai", tracks2, artists2));
        return listAlbumn;
    }

    public Track getMaxViewCount(List<Albumn> listAlbumn) {
        Track MaxView = (Track) listAlbumn.stream()
                .flatMap(e -> e.getTracks().stream())
                .collect(Collectors.toList())
                .stream()
                .max(Comparator.comparing(Track :: getViewCount))
                .get();
        return MaxView;

    }

    public Track getMinViewCount(List<Albumn> listAlbumn) {
        Track MinView = (Track) listAlbumn.stream()
                .flatMap(e -> e.getTracks().stream())
                .collect(Collectors.toList())
                .stream()
                .min(Comparator.comparing(Track :: getViewCount))
                .get();
        return MinView;
        
    }

        public long countTracks(List<Albumn> listAlbumn) {
            long count1 = listAlbumn.stream()
                    .flatMap(e -> e.getTracks().stream())
                    .collect(Collectors.toList())
                    .stream()
                    .count();
        return count1;
        }
    public static void main(String[] args) {
        List<Albumn> listAlbumn = new ArrayList<>();
        AlbumnManagement a = new AlbumnManagement();
        listAlbumn = a.initiateAlbumnList();
        System.out.println(a.getMaxViewCount(listAlbumn));
        System.out.println(a.getMinViewCount(listAlbumn));
        System.out.println(a.countTracks(listAlbumn));
        
        
    }
}
