/*
 * Copyright (C) 2013 DivineCorporation
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.openbase.planetsudo.game.strategy;

import org.openbase.planetsudo.level.levelobjects.AgentInterface;
import org.openbase.planetsudo.level.levelobjects.Resource;

/**
 *
 * @author Divine <DivineThreepwood@gmail.com>
 */
public class TomsStrategy extends AbstractStrategy {

    public TomsStrategy() {
    }

    public TomsStrategy(AgentInterface a) {
        super(a);
    }

    /**
     * Gib hier an wie viele Agenten dein Team besitzen soll.
     *
     * @return Anzahl der Agenten
     */
    @Override
    protected int loadAgentCount() {
        return 3;
    }

    @Override
    protected void loadRules() {
        //-------------------------------------------->
        createRule(new Rule(1, "Gehen") {
            @Override
            protected boolean constraint() {
                return true;
            }

            @Override
            protected void action() {
                agent.go();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(1000, "Ausweichen") {
            @Override
            protected boolean constraint() {
                return agent.isCollisionDetected();
            }

            @Override
            protected void action() {
                agent.turnRandom();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(990, "Kaempfen") {
            @Override
            protected boolean constraint() {
                return agent.isUnderAttack();
            }

            @Override
            protected void action() {
                agent.fightWithAdversaryAgent();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(964, "ResourcenSuchen") {
            @Override
            protected boolean constraint() {
                return agent.seeResource();
            }

            @Override
            protected void action() {
                agent.goToResource();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(959, "ResourcenNehmen") {
            @Override
            protected boolean constraint() {
                return agent.isTouchingResource();
            }

            @Override
            protected void action() {
                agent.pickupResource();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(961, "ResourceWegBringen") {
            @Override
            protected boolean constraint() {
                return agent.isCarringResource();
            }

            @Override
            protected void action() {
                agent.goToMothership();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(962, "ResourceGeben") {
            @Override
            protected boolean constraint() {
                return agent.isAtMothership() && agent.isCarringResource();

            }

            @Override
            protected void action() {
                agent.deliverResourceToMothership();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(963, "Angreifen") {
            @Override
            protected boolean constraint() {
                return agent.seeAdversaryAgent();
            }

            @Override
            protected void action() {
                agent.fightWithAdversaryAgent();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(989, "MutterschiffZerstoeren") {
            @Override
            protected boolean constraint() {
                return agent.seeAdversaryMothership();
            }

            @Override
            protected void action() {
                agent.fightWithAdversaryMothership();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(951, "Helfen") {
            @Override
            protected boolean constraint() {
                return agent.seeLostTeamAgent();
            }

            @Override
            protected void action() {
                agent.spendTeamAgentFuel(1200);
            }
        });

        //-------------------------------------------->
        createRule(new Rule(975, "CaptainKaempfen") {
            @Override
            protected boolean constraint() {
                return agent.isCommander() && agent.seeAdversaryAgent();
            }

            @Override
            protected void action() {
                agent.fightWithAdversaryAgent();
            }
        });

//		-------------------------------------------->
        createRule(new Rule(875, "HoleTreibstoff") {
            @Override
            protected boolean constraint() {
                return agent.getFuelInPercent() < 30;
            }

            @Override
            protected void action() {
                agent.goToMothership();
            }
        });

//		-------------------------------------------->
        createRule(new Rule(876, "NimmTreibstoff") {
            @Override
            protected boolean constraint() {
                return agent.isAtMothership() && agent.getFuelInPercent() < 70;
            }

            @Override
            protected void action() {
                agent.orderFuel(100);
            }
        });
//        
        //-------------------------------------------->
        createRule(new Rule(1002, "Mine") {
            @Override
            protected boolean constraint() {
                return agent.isFighting() && agent.getFuelInPercent() < 80;
            }

            @Override
            protected void action() {
                agent.deployMine();
            }
        });
//        
        //-------------------------------------------->
        createRule(new Rule(914, "ZuMarker") {
            @Override
            protected boolean constraint() {
                return mothership.isMarkerDeployed();
            }

            @Override
            protected void action() {
                agent.goToMarker();
            }
        });
//        
        //-------------------------------------------->
        createRule(new Rule(950, "AgentRetten") {
            @Override
            protected boolean constraint() {
                return mothership.needSomeoneSupport();
            }

            @Override
            protected void action() {
                agent.goToSupportAgent();
            }
        });
//        
        //-------------------------------------------->
        createRule(new Rule(949, "HilfeRufen") {
            @Override
            protected boolean constraint() {
                return agent.getFuelInPercent() < 15;
            }

            @Override
            protected void action() {
                agent.orderSupport();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(1001, "EndeDesSpiels") {
            @Override
            protected boolean constraint() {
                return agent.isGameOverSoon();
            }

            @Override
            protected void action() {
                agent.goToMothership();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(913, "MutterschiffBeschuetzen") {
            @Override
            protected boolean constraint() {
                return mothership.isDamaged();
            }

            @Override
            protected void action() {
                agent.goToMothership();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(912, "MutterschiffReparieren") {
            @Override
            protected boolean constraint() {
                return agent.isAtMothership() && mothership.isDamaged();
            }

            @Override
            protected void action() {
                agent.repairMothership();
            }
        });
        //-------------------------------------------->
        createRule(new Rule(910, "5PWegbringen") {
            @Override
            protected boolean constraint() {
                return agent.isAtMothership() && agent.isCarringResource(Resource.ResourceType.ExtremPoint);
            }

            @Override
            protected void action() {
                agent.deliverResourceToMothership();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(911, "MarkerSetzen") {
            @Override
            protected boolean constraint() {
                return agent.isTouchingResource(Resource.ResourceType.ExtremPoint);
            }

            @Override
            protected void action() {
                agent.deployMarker();
            }
        });

        //-------------------------------------------->
        createRule(new Rule(915, "WegMit5P") {
            @Override
            protected boolean constraint() {
                return agent.isCarringResource(Resource.ResourceType.ExtremPoint);
            }

            @Override
            protected void action() {
                agent.goToMothership();
            }
        });

//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
//        
//		//-------------------------------------------->
//		createRule(new Rule(915, "WegMit5P") {
//			@ Override
//			protected boolean constraint() {
//				return agent.
//			}
//			@ Override
//			protected void action() {
//				agent.
//			}
//		});
    }
}
