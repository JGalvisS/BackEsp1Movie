package com.dh.movieservice.rabbitmq;

import com.dh.movieservice.model.Movie;
import com.dh.movieservice.service.MovieService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {
    private final MovieService movieService;
    public  MovieListener (MovieService movieService) {this.movieService = movieService;}
    @RabbitListener (queues = {"${queue.movie.name}"})
    public void receive(@Payload Movie movie){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }movieService.save(movie);
    }


}
