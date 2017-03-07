# MidiBlabber

To be brief, the goal of this project was to create a sort of dialog reader that took text and transformed it into nonsense that almost resembled dialog.

This project was constructed using the Netbeans Swing GUI editor, and Netbeans is also used to maintain this repository. For best results, use Netbeans when working with this repository.

The Far Less Brief Summary
--------------------------
This project was inspired by two games that have unusual, pseudo-voice acting: **Animal Crossing**, and **Don't Starve**. 

In **Animal Crossing**, the dialog comes across as this sort of [blathering nonsense](https://www.youtube.com/watch?v=jqqTVf5j6Nc). In actuality, what's happening is that the 'proper' names of the letters are being read aloud. This is sped up and overlapped, to create the appearance of nonsense that actually has an overlying structure (I deserve no credit for this observation, I found it [here](https://www.reddit.com/r/gamedev/comments/3oeege/best_way_to_make_animal_crossingundertale_blarble/)).

In **Don't Starve**, the dialog comes out as [various musical notes](https://www.youtube.com/watch?v=S98-hxcVR30), with each character having their own variety of instrument that defines the timbre of their voice.

I really like both of these concepts, so I decided to mash them together. And I decided to make the sounds using MIDI. 

There were man reasons for this, foremost was that interested in working with MIDI technology. Even though MIDIs are now considered antiquated and - shall we say, out of fashion - I think they have a certain charm. Maybe that charm is purely comedic and my enjoyment is purely ironic, but that comedic charm & ironic enjoyment are still charm & enjoyment! In addition, soundcards are still made to be MIDI-compliant. So, if I used MIDI, I wouldn't have to worry about working with audio files - recording, editing, loading, or playing. My program would be able to move from machine to machine and it would work just fine. 

I also wanted to work with Java Swing - this project started in Fall 2016, and the last time I had used Swing was Fall 2015.

What Was Learned
----------------
Did I make a dialog reader that made MIDI instruments babble out dialog? Yes. Was that literally my only requirement for this project? Also yes.

So in a way, I finished the project, but I still feel like there's more experimentation to be done with this concept. What I really want to work on is signal translation methods. I realized early on that there should be multiple ways to interpret a char value as a musical note, but at the time I was unfamiliar with the variety of available algorithms. I basically came up with two varities of look-up table: normal, and slightly steeper than normal. As of this writing (March 6th, 2017) I'm more experienced in signal processing, so I'd like to return to this project.

There were also some interesting things I learned:
  * What I would qualify as an instrument's "sound" is properly referred to as the timbre. Looking through Java's MIDI documentation was partially a crash course on basic music theory.
  * The particularly high and low MIDI notes don't actually seem to produce any sound - none that I can hear, anyway. 
  * Certain instruments change their timbre based on the note they're trying to play. The piano will always have the same timbre, but the drums may change to different timbres depending on what note it was trying to play. These aberrant instruments seem to have set note ranges where certain timbres exist. Playing different notes in these ranges may, or may not, change the pitch. It changes from instrument to instrument.
  * I tested the actual portability between my Ubuntu Linux machine and my Windows 10 machine. It was interesting to see what instruments were present and how their timbres compared. My Linux machine is a Dell laptop (Inspirion 11-3152) that I bought at a discount - most people seemed to complain about a faulty OS (not a problem for Linux!) and a poor soundcard. My Windows machine is an old MSI GX60 - a gaming PC. The MIDI specification calls for, at minimum, [128 different timbres](http://soundprogramming.net/file-formats/general-midi-instrument-list/). On the Linux machine, some timbres were very similar and hard to differentiate - like piano or electirc piano. On the Windows machine, they were all very distinct - and this wasn't always good. I found I quite liked the electric piano on Linux, while the Windows version of electric piano was possibly one of the most horriffic noise I've ever heard.
  * Instruments sound very different at different pitches. Some can be painfully high.

I have takeaways for any future projects where I want to implement something like this:
  1. Instruments should be grouped with a signal translation method, rather than pairing the two randomly. Random pairing, while fun for experimenting, can lead to undesirable results. It might produce ugly sounds, or painful sounds, or maybe no sounds at all. So in the future, I should work to produce signal translation algorithms that take advantage of the most a MIDI instrument has to offer.
  2. All soundcards are MIDI-compliant, but they're not all that compliant with each other. The basic instruments sound similar, but the flavorful instruments - electric guitar, banjo, sitar, bongos, etc. - can sound very different. Any system like this should be tested on multiple machines to ensure that the signal processing algorithms are safe when paired with an instrument.

What's Left?
------------
I want to rework the program's architecture to make it easier to add new signal translation methods. It's not too difficult right now, but its spread across a couple classes and I would like to encapsulate them. Then, Im going to add new signal translation methods - like ones that make full use of an ever-changing dynamic range.
