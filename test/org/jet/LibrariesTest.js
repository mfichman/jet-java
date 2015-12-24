
function Starship() {


    actor.addListener("Active", new org.jet.Actor.Listener() {

    });
    actor.addListener("Silly", new org.jet.Actor.Listener() {

    });
}
Starship.prototype = org.jet.Actor;

new Starship();
new Starship();

yield;