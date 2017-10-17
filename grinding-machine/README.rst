Grinding Machine
================

Abstract
--------

This is an IoT scenario of industrial condition monitoring. The machine that is
being controlled is a grinding machine for centreless grinding. The proposed solution
consists of gathering real-world data, extracting meaningful information out of it
by using Machine Learning processes, and its tranmission using the PPMP protocol.


What is a grinding machine
--------------------------

A grinding machine is a device used to remove material from a cylindrical
workpiece. See `this video <media/grinding-machine-in-action.mp4>`_
for better understanding.

In short, this kind of machine consists of a grinding wheel, a back-up wheel
and a resting platform. The workpiece is placed on top of the resting platform
and squeezed between the two wheels, which are spinning and creating the friction
to remove material. There is as well one (or two) ballscrews that push the 
wheels together, or moves them away from each other.

More in detail, the back-up wheel is usually made of rubber or other grippy
material. Its task is to both to transmit torque to the workpiece and to
counterbalance the force of the grinding wheel. From the other side comes the
grinding wheel, which is made of abrasive material. At the contact point
between it and the workpiece, the grinding wheel has a higher linear speed,
resulting in friction and the desired material removal. 

The ballscrew is a linear actuator that is responsible for the relative
position of the wheels to each other, and the force which they are squeezing
the workpiece with. A ballscrew is conceptually very similar to a leadscrew,
which consists of a screw shaft and a nut connected to it, so that the turning
motion of the shaft is converted to linear motion of the nut. However, a
ballscrew uses a ball bearing instead of a nut, which provides better
efficiency and precision. The shaft rotation is provided by an electric
motor.

Why condition monitoring
------------------------

Usually these machines are rather upstream in the manufacturing chain, i.e. a
lot of downstream processes completely depend on their proper functioning.
Moreover, even big companies have a very reduced amount of them, and they are
seldom idle, which means that the redundancy typically ranges from almost none
to none whatsoever. Therefore the proper functioning of these machines is
considered rather critical.

The normal wearing of both wheels is easy to detect (even to predict), and
executing the necessary replacements is not time consuming. On the other hand,
the progressive decay of the ballscrew is way more complicated since it cannot
be visually observed, its long-term nature makes it hard to gather enough
information to estimate its life, and on top of that, accessing and replacing
it in case of failure is extremely time consuming (taking up to days). In other
words, the most critical part of the grinding machine is its ballscrew.

The production in a factory would hugely benefit if it was possible to monitor
the health of this part, and when necessary, plan its replacement in an quiet
and organized manner instead of firefighting around.

All these reasons make the maintenance of the ballscrew an excellent candidate
for condition monitoring. 


What and how to monitor
-----------------------

One of the possible indicators of the condition of the ballscrew is the
vibration, since different levels of deterioration result in different profiles
of vibration. This can be measured with the help of an acceleration sensor
attached to the machine.

However, the vibration profile is not dependent only on the health of the
ballscrew but other factors as well, for instance the forces that the wheels
are subjected to. In order to simplify this analysis, the vibration produced by
the ballscrew should be isolated and a very easy way to achieve this is to
perform a dry-run test in which nothing is running but the ballscrew, and the
wheels are not subjected to any force. We define our dry-run test as "moving
the grinding wheel from one extreme of its range to the other, while no other
machine-relevant action or forces are taking place".

Once we have a standardized test, we can measure acceleration values for
different ballscrews that we know that are in a given condition. Arbitrarily
this has been classified as "good", "medium" or "bad" (this classfied raw data
can be found `here <unide-grinding-machine-gateway/src/training-data>`_).

Then, once we have classfied or labeled raw data, we can calculate different
statistical characteristics and then use them to train a Machine Learning
Classification Algorithm. In our case, the statistical characteristics are
deviation, RMS and skewness, whereas the chosen ML classificator is the
Gaussian Naive Bayes. With a trained classificator, we should be able to
recognize the condition of the ballscrew just by processing its vibration.


Solution architecture
---------------------
There are four entities in our solution architecture:

- The grinding machine itself.
- A (constrained) device that retrieves real-world data from the grinding
  machine via acceleration sensors, and sends this data somewhere else via PPMP over
  HTTP (see next point).
- A gateway that collects data from any number of grinding machines, classifies
  the data, and forwards the meaningful results somewhere else via PPMP over HTTP 
  (see next point).
- A "final station" platform that receives the gateways results via HTTP. The typical
  responsibilities of this entity are acting as presentation layer, creating
  actions, storing results, etc. In many cases, this platform will be located
  in the cloud.

In our Unide testbed, the grinding machine itself and the constrained device
are represented by the python programme `<unide-grinding-machine>`_,
whereas the gateway is represented by `<unide-grinding-machine-gateway>`_.
Finally the "final station" platform is represented by the Eclipse-Unide backend.

