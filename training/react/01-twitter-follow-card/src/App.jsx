import './App.css'
import { TwitterFollowCard } from './TwitterFollowCard'

export function App () {

    const users = [
        {
            userName: 'X',
            name: 'Twitter',
            isFollowing: true
        },
        {
            userName: 'shibainu',
            name: 'Shiba',
            isFollowing: false
        },
        {
            userName: 'TeslaMotors',
            name: 'Tesla',
            isFollowing: false
        }
    ]

    return (
        <>
            <section className='App'>
                <TwitterFollowCard userName="X" initialIsFollowing={isFollowing}>
                    Twitter    
                </TwitterFollowCard>
                <TwitterFollowCard userName="shibainu">
                    Shiba
                </TwitterFollowCard>
                <TwitterFollowCard userName="TeslaMotors">
                    Tesla
                </TwitterFollowCard>

                {
                    users.map(user => {
                        const { userName, name, isFollowing } = user
                        return (
                            <TwitterFollowCard key={userName} userName={userName} initialIsFollowing={isFollowing}>
                                {name}
                            </TwitterFollowCard>
                        )
                    })
                }

                {
                    users.map(({ userName, name, isFollowing }) => (
                        <TwitterFollowCard key={userName} userName={userName} initialIsFollowing={isFollowing}>
                            {name}
                        </TwitterFollowCard>
                    ))
                }
            </section>

        </>
    )
}