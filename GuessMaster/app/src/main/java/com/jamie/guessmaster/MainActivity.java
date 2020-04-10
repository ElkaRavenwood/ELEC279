package com.jamie.guessmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // class variables
//    private Button btnClearContent; // made local
//    private Button guessButton; // made local
    private TextView entityName;
    private TextView ticketSum;
    private EditText userIn;
    private String userInput;
    private ImageView entityImage;
    String answer;
    private int numberOfCandidateEntities;
    private Entity[] entities;
    private int tickets = 0;
    private Entity currentEntity;

    // entity objects
    Country usa = new Country("United States", new Date("July", 4, 1776), "Washington D.C.", 0.1);
    Person myCreator = new Person("myCreator", new Date("September", 1, 2000),"Female", 1);
    Politician trudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
    Singer dion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu", new Date("November", 6, 1981), 0.5);

    /**
     * Adds a country to the entity list
     */
    public void addEntity (Entity entity) {

        // if empty list
        if (this.numberOfCandidateEntities == 0) {
            this.entities = new Entity [++this.numberOfCandidateEntities];
            this.entities[0] = entity;
            // copies over old entities if not empty
        } else {
            Entity[] temp = new Entity[++this.numberOfCandidateEntities];
            for (int i = 0; i < this.entities.length; i ++) {
                temp[i] = this.entities[i];
            }
            // adds enw entity
            // finds type of entity
            String entityType = entity.entityType();
            Entity e;
            if (entityType.equals("country")) {
                e = (Country) entity;
            } else if (entityType.equals("singer")) {
                e = (Singer) entity;
            } else if (entityType.equals("politician")) {
                e = (Politician) entity;
            } else {
                e = (Person) entity;
            }
            // adds entity to list
            temp[this.numberOfCandidateEntities -1] = e;
            // sets new list
            this.entities = temp;
        }
    }


    /**
     * Generates a random entity from the list of entities
     * @return the random entity
     */
    public Entity genRandomEntity () {

        // Generate Random
        Random r = new Random();

        // ensures new entity
        int newEntityIndex = r.nextInt(this.numberOfCandidateEntities);
        if (currentEntity != null) {
            while (currentEntity.getName().equals(entities[newEntityIndex])) {
                newEntityIndex = r.nextInt(this.numberOfCandidateEntities);
            }
        }
        currentEntity = entities[newEntityIndex];
        // returns the entity
        return currentEntity;

    }

    // start of changeEntity
    public void changeEntity() {

        userIn.getText().clear(); // clears user input
        playGame(genRandomEntity()); // changes entity

    }

    // start of imageSetter
    public void imageSetter(Entity entity) {
        int picture;
        if (entity.equals(trudeau)) {
            picture = R.drawable.justint;
        } else if (entity.equals(dion)) {
            picture = R.drawable.celidion;
        } else if (entity.equals(myCreator)) {
            picture = R.drawable.mycreator;
        } else {
            picture = R.drawable.usaflag;
        }
        entityImage.setBackgroundResource(picture);
    }

    /**
     * Prints out welcome message based on initial entity
     * @param entity The initial, randomly generated entity
     */
    public void welcomeToGame(Entity entity) {
        AlertDialog.Builder welcomealert = new AlertDialog.Builder(MainActivity.this);
        welcomealert.setTitle("GuessMaster Game v3");
        welcomealert.setMessage(entity.welcomeMessage());
        welcomealert.setCancelable(false); // no cancel button
        welcomealert.setNegativeButton("Start Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Game is starting... Enjoy", Toast.LENGTH_SHORT).show();
            }
        });
        // show dialog
        AlertDialog dialog = welcomealert.create();
        dialog.show();
    }

    /**
     * Continues game once submit is
     */
    public void continueGame () {
    }

    /**
     * plays game with an enitity
     * @param entity the entity to play with
     */
    public void playGame (Entity entity) {
        // checks if entity exists
        if (entity == null) {
            System.exit(0);
        }

        // sets image
        imageSetter(entity);
        // Print the name off the entity to be guessed to the entityName TextView
        entityName.setText(entity.getName());

        // compares result
        // Get Input from the EdiText
        answer = userIn.getText().toString();
        answer = answer.replace("\n", "").replace("\r","");
        Date result = new Date ( answer ) ;

        // Clear Previous Entry
        userIn.getText().clear();

        // if user inputs quit, exits
        if (answer.equalsIgnoreCase("quit")) {
            // outputs message, exits
            System.out.println("Quitting...");
            System.exit(1);
        }

        // compares
        // if equal
        if (!answer.equals("")) {
            if (entity.getBorn().equals(result)) {
                // increments tickets
                tickets += entity.getAwardedTicketNumber();
                // Tickets awarded
                ticketSum.setText("Total Tickets: " + tickets);

                AlertDialog.Builder win = new AlertDialog.Builder(MainActivity.this);
                win.setTitle("You Won");
                win.setMessage("Bingo! " + entity.closingMessage() + "\nYou won " + entity.getAwardedTicketNumber() + " tickets.");
                win.setCancelable(false); // no cancel button
                win.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Win", Toast.LENGTH_SHORT).show();
                        continueGame();
                    }
                });
                // show dialog
                AlertDialog dialog = win.create();
                dialog.show();
                playGame(genRandomEntity());
                return;
                // if precedes
            } else if (entity.getBorn().precedes(result)) {
                AlertDialog.Builder precede = new AlertDialog.Builder(MainActivity.this);
                precede.setTitle("Incorrect");
                precede.setMessage("Incorrect, try an earlier date");
                precede.setCancelable(false); // no cancel button
                precede.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Ok", Toast.LENGTH_SHORT).show();
                    }
                });
                // show dialog
                AlertDialog dialog = precede.create();
                dialog.show();

                // if not precedes
            } else {
                System.out.println("Incorrect, try a later date.");
                AlertDialog.Builder follow = new AlertDialog.Builder(MainActivity.this);
                follow.setTitle("Incorrect");
                follow.setMessage("Incorrect, try a later date");
                follow.setCancelable(false); // no cancel button
                follow.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "Ok", Toast.LENGTH_SHORT).show();
                    }
                });
                // show dialog
                AlertDialog dialog = follow.create();
                dialog.show();
            }
        }

    }


    /**
     * uses currentnNtity and the first playGame to run
     */
    public void playGame () {
        // randomly starts the game
        this.playGame(currentEntity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Specify the button in the view
        Button guessButton = (Button) findViewById(R.id.btnGuess);

        // EditText for user input
        userIn = (EditText) findViewById(R.id.guessInput);

        // TextView for total tickets
        ticketSum = (TextView)findViewById(R.id.tickets);

        // TextView for entity name
        entityName = (TextView) findViewById(R.id.entityName);

        // Button for clearing content
        Button btnClearContent = (Button) findViewById(R.id.btnClear);

        // ImageView for entity image
        entityImage = (ImageView) findViewById(R.id.entityImage);


        // OnClick listener for clear button
        btnClearContent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                changeEntity();
            }
        });

        // OnClick listener for submit button
        guessButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                playGame();
            }
        });

        addEntity(dion);
        addEntity(usa);
        addEntity(myCreator);
        addEntity(trudeau);
        playGame(genRandomEntity());
    }
}
